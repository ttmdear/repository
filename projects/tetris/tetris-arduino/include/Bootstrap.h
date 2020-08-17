#ifndef SIMPLE_EXAMPLE_BOOTSTRAP_H
#define SIMPLE_EXAMPLE_BOOTSTRAP_H

#include "Display.h"
#include "Gamepad.h"
#include "GameTetris.h"
#include "Audio.h"

class Bootstrap {
    Display* display;
    Gamepad* gamepad;
    GameTetris* gameTetris;
    Audio* audio;
public:
    Bootstrap();
    ~Bootstrap();

    void setup();
    void loop();
};

#endif //SIMPLE_EXAMPLE_BOOTSTRAP_H
