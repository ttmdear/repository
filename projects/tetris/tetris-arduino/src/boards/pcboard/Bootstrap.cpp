#include "../../boards/include/Bootstrap.h"
#include "../../boards/include/GameTetris.h"
#include <allegro5/allegro.h>

Bootstrap::Bootstrap() {}

Bootstrap::~Bootstrap() {
    delete display;
    delete gamepad;
}

void Bootstrap::run() {
    if(!al_init()) {
        exit(0);
    }

    // Init display and gamepad
    display = new Display(8, 15);
    gamepad = new Gamepad();

    GameTetris* gameTetris = new GameTetris(display, gamepad);

    while(true) {
        display->reload();
        gamepad->reload();
        gameTetris->reload();
    }
}
