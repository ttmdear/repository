#ifndef SIMPLE_EXAMPLE_DISPLAY_H
#define SIMPLE_EXAMPLE_DISPLAY_H

#include "Bitmap.h"
#include <allegro5/allegro.h>
#include <allegro5/allegro_font.h>
#include <string>

class Display {
private:
    Bitmap* bitmap;

    ALLEGRO_FONT *fonts;
    ALLEGRO_DISPLAY *display;

    std::string toprint;

    unsigned long timeoutReload;
public:
    Display(char width, char height);
    ~Display();

    void reload();
    char getWidth();
    char getHeight();
    void loadBitmap(Bitmap* bitmap);
    void print(const char *text);
};

#endif //SIMPLE_EXAMPLE_DISPLAY_H
