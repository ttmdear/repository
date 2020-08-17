//
// Created by thinkpad on 27.12.2019.
//
#include <allegro5/allegro.h>
#include <deque>

#ifndef SIMPLE_EXAMPLE_GAMEPAD_H
#define SIMPLE_EXAMPLE_GAMEPAD_H

class Gamepad {
private:
    ALLEGRO_EVENT_QUEUE* eventQueue;
    std::deque<char>* buttons;
public:
    static const char BUTTON_RIGHT = 1;
    static const char BUTTON_LEFT = 2;
    static const char BUTTON_DOWN = 3;
    static const char BUTTON_UP = 4;
    static const char BUTTON_A = 5;
    static const char BUTTON_B = 6;
    static const char BUTTON_RESET = 7;
    static const char BUTTON_NONE = 0;

    Gamepad();
    ~Gamepad();

    char isButtons();
    void reload();

    char getButton();
};

#endif //SIMPLE_EXAMPLE_GAMEPAD_H
