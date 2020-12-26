#ifndef GAME_BOARD_DISPLAY_H
#define GAME_BOARD_DISPLAY_H

#include <allegro5/allegro.h>
#include <allegro5/allegro_primitives.h>
#include <allegro5/allegro_font.h>

class Display {
private:
    ALLEGRO_FONT *fonts;
    ALLEGRO_DISPLAY *display;

    unsigned long timeoutReload;
public:
    void reload();

    Display();

    virtual ~Display();
};

#endif //GAME_BOARD_DISPLAY_H
