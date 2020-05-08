#include <IRremote.h>
#include <IRremoteInt.h>

#define IR_INPUT A0

IRrecv irrecv(IR_INPUT);
decode_results results;

#define KEY_ARROW_RIGHT 3772794553
#define KEY_ARROW_DOWN 3772810873
#define KEY_ARROW_LEFT 3772819033
#define KEY_ARROW_UP 3772778233
#define KEY_MENU 3772799143

void setup() {
    Serial.begin(9600);

    irrecv.enableIRIn(); // uruchamia odbiornik podczerwieni
}

void loop() {
    if (irrecv.decode(&results)) {
        // Serial.print(results.value);
        // Serial.println(" ");

        switch(results.value) {
            case KEY_ARROW_RIGHT:
                Serial.println("KEY_ARROW_RIGHT");
                break;
            case KEY_ARROW_DOWN:
                Serial.println("KEY_ARROW_DOWN");
                break;
            case KEY_ARROW_LEFT:
                Serial.println("KEY_ARROW_LEFT");
                break;
            case KEY_ARROW_UP:
                Serial.println("KEY_ARROW_UP");
                break;
            case KEY_MENU:
                Serial.println("KEY_MENU");
                break;
        }

        irrecv.resume(); // odbiera następną wartość

        delay(100);
    }
}
