#ifndef SIMPLE_EXAMPLE_GAMETETRIS_H
#define SIMPLE_EXAMPLE_GAMETETRIS_H

#include "Display.h"
#include "tetriminos/Tetrimino.h"
#include "Bitmap.h"
#include "Gamepad.h"

class GameTetris {
private:
    // Display pointer
    Display* display;

    Gamepad* gamepad;

    // Gameplay bitmap
    Bitmap* bitmap;

    char* filledlines;

    // Height and width of display and bitmap.
    char width;
    char height;

    // Active tetrimino
    Tetrimino* tetrimino;

    char tetriminoX;
    char tetriminoY;

    unsigned int points = 0;

    unsigned long timeoutReload;
    unsigned long timeoutMoveDown;

    Tetrimino tetriminos[7];

    char tetriminoLast = 0;

    char state = STATE_LOAD_TETRIMINO;
public:
    static const char MOVE_DIRECT_NONE = 'n';
    static const char MOVE_DIRECT_RIGHT = 'r';
    static const char MOVE_DIRECT_LEFT = 'l';
    static const char MOVE_DIRECT_DOWN = 'd';

    static const char STATE_MOVING = 1;
    static const char STATE_LOAD_TETRIMINO = 2;
    static const char STATE_CLEANING_LINES = 3;
    static const char STATE_END = 4;

    static const char MOVE_RESULT_STOP = 1;
    static const char MOVE_RESULT_CONTINUE = 2;
    static const char MOVE_RESULT_DISALLOWED = 3;

    GameTetris(Display *display, Gamepad *gamepad);

    void reload();
    void move(char direct);

    void addToPoint(unsigned int points);
    void reset();

    // State processing
    void processingStateEnd();
    void processingStateMoving();
    void processingCleaningLines();

    void setState(char state);

    void loadNewTetrimino();

    void rotateTetrimino();

    void fillFilledLines(bool *filledlines, bool &isFilledLines, const char width, const char height);

    void checkFilledLines();

    void reloadDisplayBitmap();

    void countXYCordinageForMove(const char &direct, char &x, char &y);

    bool isAllowedMove(char direct);

    void persistTetriminoToBitmap();

    unsigned int getPoints() const;
};

#endif //SIMPLE_EXAMPLE_GAMETETRIS_H
