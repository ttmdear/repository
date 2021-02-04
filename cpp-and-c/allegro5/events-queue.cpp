// It's example of procesing events queue.
while(!al_is_event_queue_empty(eventQueue)) {
    al_get_next_event(eventQueue, &event);

    if (event.type == ALLEGRO_EVENT_KEY_DOWN) {
        switch (event.keyboard.keycode) {
            case ALLEGRO_KEY_UP:
                buttons[BUTTON_UP] = 1;
                break;
            case ALLEGRO_KEY_DOWN:
                buttons[BUTTON_DOWN] = 1;
                break;
            case ALLEGRO_KEY_LEFT:
                buttons[BUTTON_LEFT] = 1;
                break;
            case ALLEGRO_KEY_RIGHT:
                buttons[BUTTON_RIGHT] = 1;
                break;
        }
    } else if (event.type == ALLEGRO_EVENT_KEY_UP) {
        switch (event.keyboard.keycode) {
            case ALLEGRO_KEY_UP:
                buttons[BUTTON_UP] = 0;
                break;
            case ALLEGRO_KEY_DOWN:
                buttons[BUTTON_DOWN] = 0;
                break;
            case ALLEGRO_KEY_LEFT:
                buttons[BUTTON_LEFT] = 0;
                break;
            case ALLEGRO_KEY_RIGHT:
                buttons[BUTTON_RIGHT] = 0;
                break;
        }
    }
