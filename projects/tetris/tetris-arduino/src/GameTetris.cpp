#include "../include/tetriminos/ITetrimino.h"
#include "../include/tetriminos/TTetrimino.h"
#include "../include/tetriminos/JTetrimino.h"
#include "../include/tetriminos/LTetrimino.h"
#include "../include/tetriminos/OTetrimino.h"
#include "../include/tetriminos/STetrimino.h"
#include "../include/tetriminos/ZTetrimino.h"
#include "../include/GameTetris.h"
#include "../include/Audio.h"
#include <Arduino.h>

#define F false;
#define T true;

GameTetris::GameTetris(Display *display, Gamepad *gamepad, Audio *audio) {
    width = display->getWidth();
    height = display->getHeight();

    this->gamepad = gamepad;
    this->audio = audio;

    bitmap = new Bitmap(width, height);

    this->display = display;

    timeoutReload = millis();
    timeoutMoveDown = millis();
    timeoutDisplayMessage = millis();

    // Load tetriminos
    tetriminos = new Tetrimino*[7];

    tetriminos[0] = new ITetrimino();
    tetriminos[1] = new JTetrimino();
    tetriminos[2] = new LTetrimino();
    tetriminos[3] = new OTetrimino();
    tetriminos[4] = new STetrimino();
    tetriminos[5] = new TTetrimino();
    tetriminos[6] = new ZTetrimino();

    loadNewTetrimino();

    setState(STATE_BEGIN);
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
    } else if (state == STATE_BEGIN) {
        processingStateBegin();
    } else if (state == STATE_CLEANING_LINES) {
        processingCleaningLines();
    } else if (state == STATE_MOVING_DOWN) {
        processStateMovingDown();
    }

    // updateMessages();
    reloadDisplayBitmap();
}

void GameTetris::updateMessages() {
    String r1 = String("Punkty: ");
    r1.concat(getPoints());

    display->print(0, r1);

    String r2 = String("N. klocek: ");
    r2.concat(getNextTetrimino()->getCode());

    display->print(1, r2);
}

void GameTetris::processingStateMoving() {
    soundPlayed = false;

    if (audio->isPlaying()) {
        audio->stopPlaying();
    }

    int direct = MOVE_DIRECT_NONE;

    if (millis() - timeoutMoveDown > 1000) {
        processMove(MOVE_DIRECT_DOWN);

        timeoutMoveDown = millis();

        if (!isState(STATE_MOVING)) {
            return;
        }
    }

    if (gamepad->isButtons()) {
        int button = gamepad->getButton();

        if (button == Gamepad::BUTTON_LEFT) {
            direct = MOVE_DIRECT_LEFT;
        } else if (button == Gamepad::BUTTON_RIGHT) {
            direct = MOVE_DIRECT_RIGHT;
        } else if (button == Gamepad::BUTTON_DOWN) {
            setState(STATE_MOVING_DOWN);
            // return;
        } else if (button == Gamepad::BUTTON_UP) {
            rotateTetrimino();
        }
    }

    if (isState(STATE_MOVING)) {
        processMove(direct);

        updateMessages();
    }
}

void GameTetris::processMove(int direct) {
    if (direct == MOVE_DIRECT_NONE) return;

    bool isAllowedMove = this->isAllowedMove(direct);

    if (!isAllowedMove && (direct == MOVE_DIRECT_LEFT || direct == MOVE_DIRECT_RIGHT)) {
        return;
    }

    if (!isAllowedMove && direct == MOVE_DIRECT_DOWN) {
        if (tetriminoY == 0) {
            setState(STATE_END);

            return;
        } else {
            // Procesing stop
            persistTetriminoToBitmap();

            loadNewTetrimino();

            setState(STATE_MOVING);

            // Check if there are filled lines. If then state is changed to STATE_CLEANING_LINES, other state
            // not change.
            checkFilledLines();

            return;
        }
    } else {
        move(direct);
    }
}

void GameTetris::processingStateEnd() {
    display->print(0, "Koniec gry");
    display->print(1, "Punkty: ", getPoints());

    if (gamepad->isButtons()) {
        gamepad->getButton();

        setState(STATE_BEGIN);
    }
}

void GameTetris::processStateMovingDown() {
    processMove(MOVE_DIRECT_DOWN);
}

void GameTetris::setState(int state) {
    stateLast = this->state;

    this->state = state;
}

int GameTetris::getStateLast() const {
    return stateLast;
}

void GameTetris::checkFilledLines() {
    // Check filled lines
    int width = this->bitmap->getWidth();
    int height = this->bitmap->getHeight();
    bool filledlines[height];
    bool isFilledLines = false;
    bool** bitmap = this->bitmap->getPointer();

    fillFilledLines(filledlines, isFilledLines, width, height);

    if (!isFilledLines) return;

    this->filledlines = new int[height];

    for(int y = 0; y < height; y++) {
        if (filledlines[y]) {
            this->filledlines[y] = width-1;
        } else {
            this->filledlines[y] = -2;
        }
    }

    setState(STATE_CLEANING_LINES);
}

void GameTetris::rotateTetrimino() {
    tetrimino->rotate();
}

void GameTetris::move(int direct) {
    countXYCordinageForMove(direct, tetriminoX, tetriminoY);
}

bool GameTetris::isAllowedMove(int direct) {
    int tetriminoYNew = tetriminoY;
    int tetriminoXNew = tetriminoX;

    countXYCordinageForMove(direct, tetriminoXNew, tetriminoYNew);

    int tetriminoWidth = tetrimino->getWidth();
    int tetriminoHeight = tetrimino->getHeight();

    if (tetriminoXNew < 0) return false;
    if (tetriminoXNew + tetriminoWidth > width) return false;

    bool** tetriminoBitmap = tetrimino->getBitmap()->getPointer();
    bool** bitmap = this->bitmap->getPointer();

    bool result = true;

    if (tetriminoYNew + tetriminoHeight > height) {
        result = false;
    } else {
        bool out = false;

        for(int y = 0; y < tetriminoHeight; y++) {
            if (out) break;

            for(int x = 0; x < tetriminoWidth; x++) {
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

void GameTetris::countXYCordinageForMove(const int &direct, int &x, int &y) {
    if (direct == MOVE_DIRECT_DOWN) {
        y++;
    } else if (direct == MOVE_DIRECT_LEFT) {
        x--;
    } else if (direct == MOVE_DIRECT_RIGHT) {
        x++;
    }
}

void GameTetris::persistTetriminoToBitmap() {
    int tetriminoWidth = tetrimino->getWidth();
    int tetriminoHeight = tetrimino->getHeight();

    bool** tetriminoBitmap = tetrimino->getBitmap()->getPointer();
    bool** bitmap = this->bitmap->getPointer();

    for(int y = 0; y < tetriminoHeight; y++) {
        for(int x = 0; x < tetriminoWidth; x++) {
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

    if (tetrimino != NULL) {
        displayBitmap.load(tetrimino->getBitmap()->getPointer(), tetrimino->getWidth(), tetrimino->getHeight(), tetriminoX, tetriminoY, true);
    }

    display->loadBitmap(&displayBitmap);
}

void GameTetris::loadNewTetrimino() {
    if (nextTetrimino == NULL) {
        nextTetrimino = getRandomTetrimino();
    }

    tetrimino = nextTetrimino;

    nextTetrimino = getRandomTetrimino();

    tetriminoY = 0;
    tetriminoX = 0;
}

Tetrimino* const GameTetris::getNextTetrimino() {
    return nextTetrimino;
}

Tetrimino *GameTetris::getRandomTetrimino() {
    randomSeed(analogRead(0));

    return tetriminos[random(6)];
}

void GameTetris::fillFilledLines(bool filledlines[], bool &isFilledLines, const int width, const int height) {
    bool** bitmap = this->bitmap->getPointer();

    for(int y = height-1; y >= 0; y--) {
        bool filled = true;

        for(int x = 0; x < width; x++) {
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
    int linenumber = -1;

    int height = this->bitmap->getHeight();
    int width = this->bitmap->getWidth();
    bool** bitmap = this->bitmap->getPointer();

    for(int y = 0; y<height; y++) {
        if (filledlines[y] >= -1) {
            linenumber = y;
            break;
        }
    }

    if (linenumber == -1) {
        delete [] filledlines;

        setState(STATE_MOVING);
    } else {
        if (filledlines[linenumber] == -1) {
            for(int y = linenumber; y > 0; y--) {
                for(int x = 0; x < width; x++) {
                    bitmap[y][x] = bitmap[y-1][x];
                }
            }

            filledlines[linenumber] = -2;
        } else {
            for(int x = filledlines[linenumber]; x < width; x++) {
                bitmap[linenumber][x] = false;
            }

            filledlines[linenumber]--;
            addToPoint(1);
        }
    }
}

void GameTetris::addToPoint(unsigned int points) {
    this->points += points;
}

unsigned int GameTetris::getPoints() const {
    return points;
}

void GameTetris::processingStateBegin() {
    bitmap->fill(false);

    if (!soundPlayed) {
        audio->playTimes(1, 2);

        soundPlayed = 1;
    }

    if (gamepad->isButtons()) {
        // Pop button press
        gamepad->getButton();

        // Load tetrimino
        loadNewTetrimino();

        // Set state
        setState(STATE_MOVING);

        return;
    }

    tetrimino = NULL;

    display->print(0, "Nacisnij");
    display->print(1, "   przycisk !");

    bool** smile = new bool*[8];
    smile[0] = new bool[8]{false, false, false, false, false, false, false, false};
    smile[1] = new bool[8]{false, true, true, true, true, true, true, false};
    smile[2] = new bool[8]{false, true, true, true, true, true, true, false};
    smile[3] = new bool[8]{false, false, false, true, true, false, false, false};
    smile[4] = new bool[8]{false, false, false, true, true, false, false, false};
    smile[5] = new bool[8]{false, false, false, true, true, false, false, false};
    smile[6] = new bool[8]{false, false, false, true, true, false, false, false};
    smile[7] = new bool[8]{false, false, false, false, false, false, false, false};

    bitmap->load(smile, 8, 8);

    delete [] smile[0];
    delete [] smile[1];
    delete [] smile[2];
    delete [] smile[3];
    delete [] smile[4];
    delete [] smile[5];
    delete [] smile[6];
    delete [] smile[7];

    delete [] smile;
}

bool GameTetris::isState(const int state) {
    return this->state == state;
}

