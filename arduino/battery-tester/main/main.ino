#define LIGHT_GREEN 13
#define LIGHT_YELLOW 12
#define LIGHT_RED 11

// Test

void setup() {
    Serial.begin(9600);

    // analogReference(EXTERNAL);
    pinMode(LIGHT_GREEN, OUTPUT);
    pinMode(LIGHT_YELLOW, OUTPUT);
    pinMode(LIGHT_RED, OUTPUT);
}

void loop() {
    // put your main code here, to run repeatedly:

    float v = (0.0048) * analogRead(0);
    // float v = (0.0022) * analogRead(0);

    // 1.2452

    digitalWrite(LIGHT_GREEN, LOW);
    digitalWrite(LIGHT_YELLOW, LOW);
    digitalWrite(LIGHT_RED, LOW);

    if (v >= 1) {
        digitalWrite(LIGHT_GREEN, HIGH);
    } else if (v >= 0.7) {
        digitalWrite(LIGHT_YELLOW, HIGH);
    } else {
        digitalWrite(LIGHT_RED, HIGH);
    }

    Serial.println(v, 4);

    delay(1000);
}
