#include "../../../include/Gamepad.h"
#include <Arduino.h>

Gamepad::Gamepad() {

}

Gamepad::Gamepad(int pinInput) {
    this->pinInput = pinInput;
    this->reloadTimeout = millis();
}

Gamepad::~Gamepad() {

}

int Gamepad::isButtons() {
    return buttonsQueuePointer >= 0;
}

int Gamepad::getButton() {
    if (buttonsQueuePointer < 0) {
        return BUTTON_NONE;
    }

    int button = buttonsQueue[0];

    int until = buttonsQueueSize - 2;

    for(int i=0; i<until; i++) {
        buttonsQueue[i] = buttonsQueue[i+1];
    }

    buttonsQueuePointer--;

    return button;
}

void Gamepad::reload() {

    long time = millis();

    if (time - reloadTimeout < 100) {
        return;
    }

    reloadTimeout = time;

    if (buttonsQueuePointer >= buttonsQueueSize -1) {
        return;
    }

    int level = analogRead(pinInput);

    if (level > 500) {
        if (buttonsLast != BUTTON_UP) {
            buttonsQueuePointer++;
            buttonsQueue[buttonsQueuePointer] = BUTTON_UP;
            buttonsLast = BUTTON_UP;
        }

    } else if(level > 320) {
        if (buttonsLast != BUTTON_RIGHT) {
            buttonsQueuePointer++;
            buttonsQueue[buttonsQueuePointer] = BUTTON_RIGHT;
            buttonsLast = BUTTON_RIGHT;
        }
    } else if(level > 240) {
        if (buttonsLast != BUTTON_DOWN) {
            buttonsQueuePointer++;
            buttonsQueue[buttonsQueuePointer] = BUTTON_DOWN;
            buttonsLast = BUTTON_DOWN;
        }
    } else if(level > 200) {
        if (buttonsLast != BUTTON_LEFT) {
            buttonsQueuePointer++;
            buttonsQueue[buttonsQueuePointer] = BUTTON_LEFT;
            buttonsLast = BUTTON_LEFT;
        }
    } else {
        buttonsLast = BUTTON_NONE;
    }
}

