#include <Arduino.h>

void setup() {
    pinMode(LED_BUILTIN, OUTPUT);

    // while(1) {
    //     pinMode(A0, HIGH);
    // }

    // return 0;
}

void loop() {
    digitalWrite(LED_BUILTIN, HIGH);   // turn the LED on (HIGH is the voltage level)
    delay(100);                       // wait for a second
    digitalWrite(LED_BUILTIN, LOW);    // turn the LED off by making the voltage LOW
    delay(100);                       // wait for a second
}
