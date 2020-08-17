#define PIN_OUTPUT 2

void setup() {
    pinMode(PIN_OUTPUT, OUTPUT);
    pinMode(13, OUTPUT);

    // Serial.begin(9600);
}

bool state = false;

void loop() {
    if (state) {
        state = false;
        // Serial.println("state false");
    } else {
        state = true;
        // Serial.println("state true");
    }

    if (state) {
        digitalWrite(PIN_OUTPUT, HIGH);
        digitalWrite(13, HIGH);
    } else {
        digitalWrite(PIN_OUTPUT, LOW);
        digitalWrite(13, LOW);
    }

    // Serial.println("test");
    // delay();
    // delayMicroseconds(500);// 30
    delayMicroseconds(50);
    // delayMicroseconds(25);
    // delayMicroseconds(1);

    // delay(500);
}
