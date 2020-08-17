#ifdef PC_BOARD
#include <allegro5/allegro.h>
#include <deque>
#endif

#ifndef SIMPLE_EXAMPLE_GAMEPAD_H
#define SIMPLE_EXAMPLE_GAMEPAD_H

#include "board.h"

class Gamepad {
private:
#ifdef PC_BOARD
    ALLEGRO_EVENT_QUEUE* eventQueue;
    std::deque<int>* buttons;
#endif
#ifdef BOARD_ARDUINO
    int buttonsQueue[10];
    int buttonsQueueSize = 10;
    int buttonsQueuePointer = -1;
    int pinInput;
    int buttonsLast = BUTTON_NONE;
    long reloadTimeout;
#endif
public:
    static const int BUTTON_RIGHT = 1;
    static const int BUTTON_LEFT = 2;
    static const int BUTTON_DOWN = 3;
    static const int BUTTON_UP = 4;
    static const int BUTTON_A = 5;
    static const int BUTTON_B = 6;
    static const int BUTTON_RESET = 7;
    static const int BUTTON_NONE = 0;

    Gamepad();
    Gamepad(int pinInput);

    ~Gamepad();

    int isButtons();
    void reload();

    int getButton();
};

#endif //SIMPLE_EXAMPLE_GAMEPAD_H
