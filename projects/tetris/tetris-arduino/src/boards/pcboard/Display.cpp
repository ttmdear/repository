#include <iostream>
#include "../include/common.h"
#include "../include/Display.h"
#include "../include/Bitmap.h"
#include <allegro5/allegro.h>
#include <allegro5/allegro_primitives.h>
#include <allegro5/allegro_font.h>

Display::Display(int width, int height) {
    // Create bitmap
    bitmap = new Bitmap(width, height);

    // Set last reload timeout
    timeoutReload = millis();

    // Tworzymy okno, odbieramy wskaźnik, sprawdzamy zwrot
    display = al_create_display(1024, 748);

    if(!display) {
        fprintf(stderr, "Failed to create display!\n");

        exit(0);
    }

    al_init_primitives_addon();
    al_init_font_addon();

    fonts = al_create_builtin_font();
}

Display::~Display() {
    delete bitmap;

    al_destroy_font(fonts);
    al_destroy_display(display);
}

int Display::getWidth() {
    return bitmap->getWidth();
}

int Display::getHeight() {
    return bitmap->getHeight();
}

void Display::reload() {
    long time = millis();

    if (time - timeoutReload < 100) {
        return;
    }

    timeoutReload = time;

    bool** bitmapPointer = bitmap->getPointer();

    int size = 20;

    al_clear_to_color(al_map_rgb(255, 255, 255));

    int height = bitmap->getHeight();
    int width = bitmap->getWidth();

    for(int y = 0; y < height; y++) {
        for(int x = 0; x < width; x++) {
            int y1 = y * size + (10 * y) + 10;
            int x1 = x * size + (10 * x) + 10;

            int y2 = y1 + size;
            int x2 = x1 + size;

            if (bitmapPointer[y][x]) {
                al_draw_filled_rectangle(x1, y1, x2, y2, al_map_rgb(175, 54, 54));
            } else {
                al_draw_filled_rectangle(x1, y1, x2, y2, al_map_rgb(229, 229, 229));
            }
        }
    }

    al_draw_text(fonts, al_map_rgb(120,120,120), 580, 100, 0, toprint.c_str());

    al_flip_display();
}

void Display::loadBitmap(Bitmap *bitmap) {
    this->bitmap->load(bitmap);
}

void Display::print(const int *text) {
    // strcpy(toprint, text);
    toprint.clear();
    toprint.append(text);
}

