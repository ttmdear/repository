#include <iostream>
#include "GameTetris.h"
#include "common.h"
#include "tetriminos/ITetrimino.h"
#include "Gamepad.h"
#include "tetriminos/TTetrimino.h"
#include "tetriminos/JTetrimino.h"
#include "tetriminos/LTetrimino.h"
#include "tetriminos/OTetrimino.h"
#include "tetriminos/STetrimino.h"
#include "tetriminos/ZTetrimino.h"
#include <string>

GameTetris::GameTetris(Display *display, Gamepad *gamepad) {
    width = display->getWidth();
    height = display->getHeight();

    this->gamepad = gamepad;

    bitmap = new Bitmap(width, height);

    this->display = display;

    timeoutReload = millis();
    timeoutMoveDown = millis();

    // Load tetriminos
    tetriminos[0] = ITetrimino();
    tetriminos[1] = JTetrimino();
    tetriminos[2] = LTetrimino();
    tetriminos[3] = OTetrimino();
    tetriminos[4] = STetrimino();
    tetriminos[5] = TTetrimino();
    tetriminos[6] = ZTetrimino();

    loadNewTetrimino();

    setState(STATE_MOVING);
};

void GameTetris::reload() {
    // Check reload timeout
    unsigned long time = millis();

    if (time - timeoutReload < 100) return;

    timeoutReload = time;

    // Processing states
    if (state == STATE_MOVING) {
        processingStateMoving();
    } else if (state == STATE_END) {
        processingStateEnd();
    } else if (state == STATE_CLEANING_LINES) {
        processingCleaningLines();
    }

    std::string message = std::string("Liczba punktow: ") + std::to_string(points);
    display->print(message.c_str());

    reloadDisplayBitmap();
}

void GameTetris::processingStateMoving() {
    char direct = MOVE_DIRECT_NONE;

    if (gamepad->isButtons()) {
        char button = gamepad->getButton();

        if (button == Gamepad::BUTTON_LEFT) {
            direct = MOVE_DIRECT_LEFT;
        } else if (button == Gamepad::BUTTON_RIGHT) {
            direct = MOVE_DIRECT_RIGHT;
        } else if (button == Gamepad::BUTTON_DOWN) {

        } else if (button == Gamepad::BUTTON_UP) {
            rotateTetrimino();
        }
    }

    if (millis() - timeoutMoveDown > 300) {
        direct = MOVE_DIRECT_DOWN;

        timeoutMoveDown = millis();
    }

    if (direct == MOVE_DIRECT_NONE) return;

    bool isAllowedMove = this->isAllowedMove(direct);

    if (!isAllowedMove && (direct == MOVE_DIRECT_LEFT || direct == MOVE_DIRECT_RIGHT)) return;

    if (!isAllowedMove && direct == MOVE_DIRECT_DOWN) {
        // Procesing stop
        persistTetriminoToBitmap();

        loadNewTetrimino();

        // Check if there are filled lines. If then state is changed to STATE_CLEANING_LINES, other state
        // not change.
        checkFilledLines();

        return;
    } else {
        move(direct);
    }
}

void GameTetris::setState(char state) {
    this->state = state;
}

void GameTetris::processingStateEnd() {
    // ...
}

void GameTetris::checkFilledLines() {
    // Check filled lines
    char width = this->bitmap->getWidth();
    char height = this->bitmap->getHeight();
    bool filledlines[height];
    bool isFilledLines = false;

    fillFilledLines(filledlines, isFilledLines, width, height);

    if (!isFilledLines) return;

    this->filledlines = new char[height];

    for(char i = 0; i < height; i++) {
        if (filledlines[i]) {
            this->filledlines[i] = 2;
        } else {
            this->filledlines[i] = 0;
        }
    }

    setState(STATE_CLEANING_LINES);
}

void GameTetris::rotateTetrimino() {
    tetrimino->rotate();
}

void GameTetris::move(char direct) {
    countXYCordinageForMove(direct, tetriminoX, tetriminoY);
}

bool GameTetris::isAllowedMove(char direct) {
    char tetriminoYNew = tetriminoY;
    char tetriminoXNew = tetriminoX;

    countXYCordinageForMove(direct, tetriminoXNew, tetriminoYNew);

    char tetriminoWidth = tetrimino->getWidth();
    char tetriminoHeight = tetrimino->getHeight();

    if (tetriminoXNew < 0) return false;
    if (tetriminoXNew + tetriminoWidth > width) return false;

    bool** tetriminoBitmap = tetrimino->getBitmap()->getPointer();
    bool** bitmap = this->bitmap->getPointer();

    bool result = true;

    if (tetriminoYNew + tetriminoHeight > height) {
        result = false;
    } else {
        bool out = false;

        for(char y = 0; y < tetriminoHeight; y++) {
            if (out) break;

            for(char x = 0; x < tetriminoWidth; x++) {
                if (direct == MOVE_DIRECT_RIGHT) {
                    if (tetriminoBitmap[y][x] && bitmap[tetriminoYNew + y][tetriminoXNew + x]) {
                        result = false;
                        out = true;

                        break;
                    }
                } else if (direct == MOVE_DIRECT_LEFT) {
                    if (tetriminoBitmap[y][x] && bitmap[tetriminoYNew + y][tetriminoXNew + x]) {
                        result = false;
                        out = true;

                        break;
                    }
                } else if (direct == MOVE_DIRECT_DOWN) {
                    if (tetriminoBitmap[y][x] && bitmap[tetriminoYNew + y][tetriminoXNew + x]) {
                        result = false;
                        out = true;

                        break;
                    }
                }
            }
        }
    }

    return result;
}

void GameTetris::countXYCordinageForMove(const char &direct, char &x, char &y) {
    if (direct == MOVE_DIRECT_DOWN) {
        y++;
    } else if (direct == MOVE_DIRECT_LEFT) {
        x--;
    } else if (direct == MOVE_DIRECT_RIGHT) {
        x++;
    }
}

void GameTetris::persistTetriminoToBitmap() {
    char tetriminoWidth = tetrimino->getWidth();
    char tetriminoHeight = tetrimino->getHeight();

    bool** tetriminoBitmap = tetrimino->getBitmap()->getPointer();
    bool** bitmap = this->bitmap->getPointer();

    for(char y = 0; y < tetriminoHeight; y++) {
        for(char x = 0; x < tetriminoWidth; x++) {
            if (tetriminoBitmap[y][x]) {
                bitmap[tetriminoY + y][tetriminoX + x] = tetriminoBitmap[y][x];
            }
        }
    }
}

void GameTetris::reloadDisplayBitmap() {
    // Create tmp display bitmap with gamebitmap and tetrimino bitmap.
    Bitmap displayBitmap(display->getWidth(), display->getHeight());

    displayBitmap.load(this->bitmap);

    displayBitmap.load(tetrimino->getBitmap()->getPointer(), tetrimino->getWidth(), tetrimino->getHeight(), tetriminoX, tetriminoY, true);

    display->loadBitmap(&displayBitmap);
}

void GameTetris::loadNewTetrimino() {
    tetriminoLast++;

    if (tetriminoLast >= 6) tetriminoLast = 0;

    tetrimino = &tetriminos[tetriminoLast];

    tetriminoY = 0;
    tetriminoX = 0;
}

void GameTetris::fillFilledLines(bool filledlines[], bool &isFilledLines, const char width, const char height) {
    bool** bitmap = this->bitmap->getPointer();

    for(char y = height-1; y >= 0; y--) {
        bool filled = true;

        for(char x = 0; x < width; x++) {
            if (!bitmap[y][x]) {
                filled = false;
                break;
            }
        }

        if (filled) isFilledLines = true;

        filledlines[y] = filled;
    }
}

void GameTetris::processingCleaningLines() {
    char linenumber = -1;

    char height = this->bitmap->getHeight();
    char width = this->bitmap->getWidth();
    bool** bitmap = this->bitmap->getPointer();

    for(char y = height; y >= 0; y--) {
        if (filledlines[y]) {
            linenumber = y;
            break;
        }
    }

    if (linenumber == -1) {
        delete [] filledlines;

        setState(STATE_MOVING);
    } else {
        for(char y = linenumber; y > 0; y--) {
            for(char x = 0; x < width; x++) {
                bitmap[y][x] = bitmap[y-1][x];
            }
        }

        filledlines[linenumber] = false;

        addToPoint(1);
    }
}

void GameTetris::addToPoint(unsigned int points) {
    this->points += points;
}

unsigned int GameTetris::getPoints() const {
    return points;
}
