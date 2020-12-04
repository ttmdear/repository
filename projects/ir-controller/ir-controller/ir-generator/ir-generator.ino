#include <IRremote.h>
#include <IRremoteInt.h>

#define IR_OUTPUT 3
#define DIODE_OUTPUT 4
#define B30_INPUT A0
#define B60_INPUT A1
#define B90_INPUT A2

IRsend irsend;

int state = 0;

#define KEY_ARROW_RIGHT 3772794553
#define KEY_ARROW_DOWN 3772810873
#define KEY_ARROW_LEFT 3772819033
#define KEY_ARROW_UP 3772778233
#define KEY_MENU 3772799143

void setup() {
    Serial.begin(9600);

    pinMode(IR_OUTPUT, OUTPUT);
    pinMode(B30_INPUT, INPUT);
    pinMode(B60_INPUT, INPUT);
    pinMode(B90_INPUT, INPUT);
    pinMode(DIODE_OUTPUT, OUTPUT);
}

void loop() {

    if (analogRead(B30_INPUT) > 1000) {
        processSleepTime(30);
    } else if (analogRead(B60_INPUT) > 1000) {
        processSleepTime(60);
    } else if (analogRead(B90_INPUT) > 1000) {
        processSleepTime(90);
    }

    delay(100);
}

void processSleepTime(int time) {
    int delayValue=500;

    digitalWrite(DIODE_OUTPUT, HIGH);

    irsend.sendSAMSUNG(KEY_MENU, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_UP, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_RIGHT, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_RIGHT, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_RIGHT, 32); delay(delayValue);

    if (time == 30) {
        irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
    } else if (time == 60) {
        irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
        irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
    } else if (time == 90) {
        irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
        irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
        irsend.sendSAMSUNG(KEY_ARROW_DOWN, 32); delay(delayValue);
    }

    irsend.sendSAMSUNG(KEY_ARROW_LEFT, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_LEFT, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_LEFT, 32); delay(delayValue);
    irsend.sendSAMSUNG(KEY_ARROW_LEFT, 32); delay(delayValue);

    digitalWrite(DIODE_OUTPUT, LOW);
}
