#include <Arduino.h>
#include <LiquidCrystal/src/LiquidCrystal.h>
#include "../../../include/Display.h"

Display::Display(
        int width,
        int height,
        int pinDS,
        int pinST,
        int pinSH,
        int pinLRS,
        int pinLE,
        int pinLD4,
        int pinLD5,
        int pinLD6,
        int pinLD7,
        int lcdWith,
        int lcdHeight
) {
    // Create bitmap
    bitmap = new Bitmap(width, height);

    // Set last reload timeout
    timeoutReload = millis();

    this->pinDS = pinDS;
    this->pinST = pinST;
    this->pinSH = pinSH;
    this->lcdWith = lcdWith;
    this->lcdHeight = lcdHeight;

    // Init lcd
    // lcd(RS, E, D4, D5, D6, D7);
    lcd = new LiquidCrystal(pinLRS, pinLE, pinLD4, pinLD5, pinLD6, pinLD7);
    lcd->begin(lcdWith, lcdHeight);

    // Init to display chars
    char initString[lcdWith];
    for(int i=0; i<lcdWith; i++) initString[i] = ' ';

    lcdDisplayed[0] = String(initString);
    lcdDisplayed[1] = String(initString);
}

Display::~Display() {
    delete bitmap;
    delete lcd;
}

int Display::getWidth() {
    return bitmap->getWidth();
}

int Display::getHeight() {
    return bitmap->getHeight();
}

void Display::reload() {
    long time = millis();

    if (time - timeoutReload < 10) {
        return;
    }

    timeoutReload = time;

    int height = bitmap->getHeight();
    int width = bitmap->getWidth();

    bool** bitmapPointer = bitmap->getPointer();

    int outputSize = height + width;
    bool output[outputSize];

    for(int i=0; i < height; i++) {
        // Wylaczam wszystkie wiersze
        for(int j=0; j < outputSize; j++)
            output[j] = 0;

        // Zapalam tylko ten aktualnie wyswietlany
        output[i] = 1;

        // Wsuwam wartosci z aktualnie wybranego wiersza
        for(int j=0; j < width; j++)
            output[height + j] = !bitmapPointer[i][j];

        digitalWrite(pinST, LOW);

        // Czyszcze rejestry
        for(int k = outputSize; k >= 0; k--) {
            digitalWrite(pinDS, LOW);
            digitalWrite(pinSH, HIGH);
            digitalWrite(pinSH, LOW);
        }

        // Wsywam wartosci
        for(int k = outputSize; k >= 0; k--) {
            digitalWrite(pinDS, output[k] ? HIGH : LOW);

            digitalWrite(pinSH, HIGH);
            digitalWrite(pinSH, LOW);
        }

        digitalWrite(pinST, HIGH);
    }

    // Display elements to print
    sendCharsToLCD(0);
    sendCharsToLCD(1);
}

void Display::sendCharsToLCD(int row) {
    String &todisplay = lcdToDisplay[row];
    String &displayed = lcdDisplayed[row];

    for(int i=0; i<lcdWith; i++) {
        if (i >= todisplay.length()) break;

        if (displayed[i] != todisplay[i]) {
            lcd->setCursor(i, row);
            lcd->print(todisplay[i]);

            displayed[i] = todisplay[i];
        }
    }
}

void Display::loadBitmap(Bitmap *bitmap) {
    this->bitmap->load(bitmap);
}

void Display::print(int row, const char* a, int b) {
    String message = String(a);

    message.concat(b);

    print(row, message);
}

void Display::print(int row, const char* text) {
    print(row, String(text));
}

void Display::print(int row, const String &text) {
    lcdToDisplay[row] = text;
}

void Display::clear() {
    for(int r=0; r<lcdHeight; r++) {
        for(int c=0; c<lcdWith; c++) {
            lcd->setCursor(c, r);
            lcd->print(" ");
        }
    }
}

