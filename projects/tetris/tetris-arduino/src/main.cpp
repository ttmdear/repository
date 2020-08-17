#include <Arduino.h>

#include "../include/Bootstrap.h"

# define PIN_DS 4 // Wejście danych
# define PIN_ST_CP 2 // Przenosi z na OUTPUT
# define PIN_SH_CP 3 // SH_CP Wsuwa bity a R_DS

Bootstrap bootstrap;

void setup() {
    bootstrap.setup();
}

void loop() {
    bootstrap.loop();
}
