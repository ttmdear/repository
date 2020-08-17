#ifndef SIMPLE_EXAMPLE_GAMETETRIS_H
#define SIMPLE_EXAMPLE_GAMETETRIS_H

#include "Display.h"
#include "Bitmap.h"
#include "Gamepad.h"
#include "tetriminos/Tetrimino.h"
#include "Audio.h"

class GameTetris {
private:
    // Display pointer
    Display* display;

    Gamepad* gamepad;
    Audio *audio;

    // Gameplay bitmap
    Bitmap* bitmap;

    int* filledlines;

    // Height and width of display and bitmap.
    int width;
    int height;

    // Active tetrimino
    Tetrimino* tetrimino = NULL;
    Tetrimino* nextTetrimino = NULL;

    String displayMessageRow1;
    String displayMessageRow2;

    int tetriminoX;
    int tetriminoY;

    bool soundPlayed = false;

    unsigned int points = 0;

    unsigned long timeoutReload;
    unsigned long timeoutDisplayMessage;
    unsigned long timeoutMoveDown;

    Tetrimino** tetriminos;

    int tetriminoLast = 0;

    int state = STATE_BEGIN;
    int stateLast = 0;
public:
    static const int MOVE_DIRECT_NONE = 'n';
    static const int MOVE_DIRECT_RIGHT = 'r';
    static const int MOVE_DIRECT_LEFT = 'l';
    static const int MOVE_DIRECT_DOWN = 'd';

    static const int STATE_MOVING = 1;
    static const int STATE_LOAD_TETRIMINO = 2;
    static const int STATE_CLEANING_LINES = 3;
    static const int STATE_END = 4;
    static const int STATE_MOVING_DOWN = 5;
    static const int STATE_BEGIN = 6;

    static const int MOVE_RESULT_STOP = 1;
    static const int MOVE_RESULT_CONTINUE = 2;
    static const int MOVE_RESULT_DISALLOWED = 3;

    // GameTetris(Display *display, Gamepad *gamepad, Audio *audio);
    GameTetris(Display *display, Gamepad *gamepad, Audio *audi);

    void reload();
    void move(int direct);

    void addToPoint(unsigned int points);
    void reset();

    // State processing
    void processingStateMoving();
    void processingCleaningLines();
    void processingStateBegin();
    void processingStateEnd();

    void setState(int state);

    void loadNewTetrimino();

    void rotateTetrimino();

    void fillFilledLines(bool *filledlines, bool &isFilledLines, const int width, const int height);

    void checkFilledLines();

    void reloadDisplayBitmap();

    void countXYCordinageForMove(const int &direct, int &x, int &y);

    bool isAllowedMove(int direct);

    void persistTetriminoToBitmap();

    unsigned int getPoints() const;

    void processMove(int direct);

    void processStateMovingDown();

    Tetrimino *const getNextTetrimino();

    Tetrimino *getRandomTetrimino();

    void updateMessages();

    bool isState(const int moving);

    int getStateLast() const;
};

#endif //SIMPLE_EXAMPLE_GAMETETRIS_H
