#include "Display.h"
#include <allegro5/allegro.h>
#include <allegro5/allegro_primitives.h>
#include <allegro5/allegro_font.h>
#include "Platform.h"
#include <iostream>

Display::~Display() {
    // delete bitmap;

    al_destroy_font(fonts);
    al_destroy_display(display);
}

Display::Display() {
    if(!al_init()) {
        fprintf(stderr, "failed to initialize allegro!\n");
        // return -1;
    }

    // Tworzymy okno, odbieramy wskaźnik, sprawdzamy zwrot
    display = al_create_display(1000, 1000);

    if (!display) {
        fprintf(stderr, "Failed to create display!\n");

        exit(0);
    }

    al_init_primitives_addon();
    al_init_font_addon();

    fonts = al_create_builtin_font();
}

// int Display::getWidth() {
//     return bitmap->getWidth();
// }
//
// int Display::getHeight() {
//     return bitmap->getHeight();
// }
//
void Display::reload() {
    return;
    unsigned long time = Platform::millis();

    if (time - timeoutReload < 100) {
        return;
    }

    timeoutReload = time;

    al_draw_filled_rectangle(10, 10, 20, 20, al_map_rgb(175, 54, 54));

    // al_draw_text(fonts, al_map_rgb(120, 120, 120), 580, 100, 0, toprint.c_str());

    al_flip_display();
}

// void Display::loadBitmap(Bitmap *bitmap) {
//     this->bitmap->load(bitmap);
// }
//
// void Display::print(const int *text) {
//     // strcpy(toprint, text);
//     toprint.clear();
//     toprint.append(text);
// }
