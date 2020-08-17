#include "../include/Gamepad.h"
#include <iostream>

Gamepad::Gamepad() {
    if(!al_install_keyboard()) {
        fprintf(stderr, "Failed to initialize allegro keyboard!\n");

        exit(0);
    }

    eventQueue = al_create_event_queue();

    if (eventQueue == NULL) {
        fprintf(stderr, "Failed to initialize events queue!\n");

        exit(0);
    }

    // Attach to queue
    al_register_event_source(eventQueue, al_get_keyboard_event_source());

    buttons = new std::deque<int>();
}

Gamepad::~Gamepad() {
    al_destroy_event_queue(eventQueue);

    delete buttons;
}

int Gamepad::isButtons() {
    return !buttons->empty();
}

int Gamepad::getButton() {
    if (buttons->empty()) return BUTTON_NONE;

    int button = buttons->back();

    buttons->pop_back();

    return button;
}

void Gamepad::reload() {
    if (al_is_event_queue_empty(eventQueue)) return;

    ALLEGRO_EVENT event;

    while(!al_is_event_queue_empty(eventQueue)) {
        al_get_next_event(eventQueue, &event);

        if (event.type == ALLEGRO_EVENT_KEY_DOWN) {
            switch (event.keyboard.keycode) {
                case ALLEGRO_KEY_UP:
                    buttons->push_front(4);
                    break;
                case ALLEGRO_KEY_DOWN:
                    buttons->push_front(3);
                    break;
                case ALLEGRO_KEY_LEFT:
                    buttons->push_front(2);
                    break;
                case ALLEGRO_KEY_RIGHT:
                    buttons->push_front(1);
                    break;
            }
        }
    }
}
