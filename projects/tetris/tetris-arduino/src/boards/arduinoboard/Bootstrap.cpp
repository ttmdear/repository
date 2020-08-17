#include "../../../include/Bootstrap.h"
#include "../../../include/GameTetris.h"
#include <Arduino.h>

#define PIN_DS 4 // Wejście danych
#define PIN_ST_CP 2 // Przenosi z na OUTPUT
#define PIN_SH_CP 3 // SH_CP Wsuwa bity a R_DS
#define PIN_GAMEPAD_INPUT A0 // SH_CP Wsuwa bity a R_DS

// #define PIN_LCD_RS 5
// #define PIN_LCD_E  5
// #define PIN_LCD_D4 7
// #define PIN_LCD_D5 8
// #define PIN_LCD_D6 9
// #define PIN_LCD_D7 10

#define PIN_LCD_RS 5
#define PIN_LCD_E  5
#define PIN_LCD_D4 7
#define PIN_LCD_D5 8
#define PIN_LCD_D6 9
#define PIN_LCD_D7 10

#define PIN_AUDIO 11

Bootstrap::Bootstrap() {}

Bootstrap::~Bootstrap() {
    delete display;
    delete gamepad;
    delete gameTetris;
}

void Bootstrap::setup() {
    // Serial.begin(9600);

    pinMode(PIN_DS, OUTPUT);
    pinMode(PIN_SH_CP, OUTPUT);
    pinMode(PIN_ST_CP, OUTPUT);
    pinMode(PIN_GAMEPAD_INPUT, INPUT);
    // pinMode(PIN_AUDIO, OUTPUT);

    // Init display and gamepad
    display = new Display(8, 15, PIN_DS, PIN_ST_CP, PIN_SH_CP, PIN_LCD_RS, PIN_LCD_E, PIN_LCD_D4, PIN_LCD_D5, PIN_LCD_D6, PIN_LCD_D7, 16, 2);
    gamepad = new Gamepad(PIN_GAMEPAD_INPUT);
    audio = new Audio(PIN_AUDIO);

    // Init game
    // gameTetris = new GameTetris(display, gamepad, audio);
    gameTetris = new GameTetris(display, gamepad, audio);
}

void Bootstrap::loop() {
    while(true) {
        gamepad->reload();
        gameTetris->reload();

        display->reload();
        audio->reload();
    }
}
