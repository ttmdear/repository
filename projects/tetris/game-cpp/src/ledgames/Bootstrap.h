//
// Created by thinkpad on 05.01.2020.
//

#ifndef SIMPLE_EXAMPLE_BOOTSTRAP_H
#define SIMPLE_EXAMPLE_BOOTSTRAP_H

#include "Display.h"
#include "Gamepad.h"

class Bootstrap {
    Display* display;
    Gamepad* gamepad;
public:
    Bootstrap();
    ~Bootstrap();

    void run();
};


#endif //SIMPLE_EXAMPLE_BOOTSTRAP_H
