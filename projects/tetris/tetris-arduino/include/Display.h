#ifndef SIMPLE_EXAMPLE_DISPLAY_H
#define SIMPLE_EXAMPLE_DISPLAY_H

#include "Bitmap.h"
#include "board.h"

#ifdef PC_BOARD
#include <allegro5/allegro.h>
#include <allegro5/allegro_font.h>
#include <string>
#endif

#ifdef BOARD_ARDUINO
#include <LiquidCrystal/src/LiquidCrystal.h>
#endif

class Display {
private:
    Bitmap* bitmap;

#ifdef PC_BOARD
    ALLEGRO_FONT *fonts;
    ALLEGRO_DISPLAY *display;

    std::string toprint;
#endif

#ifdef BOARD_ARDUINO
    int pinDS;
    int pinSH;
    int pinST;
    int lcdWith;
    int lcdHeight;

    LiquidCrystal* lcd;

    String lcdToDisplay[2];
    String lcdDisplayed[2];
#endif
    unsigned long timeoutReload;
public:
    Display(int width, int height);
#ifdef BOARD_ARDUINO
    Display(int width, int height, int pinDS, int pinST, int pinSH, int pinLRS, int pinLE, int pinLD4, int pinLD5, int pinLD6, int pinLD, int lcdWith, int lcdHeight);
#endif

    ~Display();

    void reload();
    int getWidth();
    int getHeight();
    void loadBitmap(Bitmap* bitmap);
    void print(const int *text);

    void print(int row, char* text);

    void clear();

    void print(int row, const String &text);

    void sendCharsToLCD(int row);

    void print(int row, const char *text);

    void print(int row, const char *a, int b);
};

#endif //SIMPLE_EXAMPLE_DISPLAY_H
