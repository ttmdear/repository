#define CAR_A 13
#define TA_RED 12
#define TA_YELLOW 11
#define TA_GREEN 10

#define CAR_B 5
#define TB_RED 4
#define TB_YELLOW 3
#define TB_GREEN 2

void setup() {
    Serial.begin(9600); // open the serial port at 9600 bps:

    pinMode(CAR_A, INPUT);
    pinMode(TA_RED, OUTPUT);
    pinMode(TA_YELLOW, OUTPUT);
    pinMode(TA_GREEN, OUTPUT);

    pinMode(CAR_B, INPUT);
    pinMode(TB_RED, OUTPUT);
    pinMode(TB_YELLOW, OUTPUT);
    pinMode(TB_GREEN, OUTPUT);

    // pinMode(RESISTOR, INPUT);
}

int direct = 1;

void loop() {
    Serial.print("loop");
    // Serial.println();
    // Serial.println(analogRead(A1));

    if (digitalRead(CAR_A) == HIGH) {
        direct = 1;
    } else if (digitalRead(CAR_B) == HIGH) {
        direct = 2;
    }

    if (direct == 1) {
        // Change TB
        digitalWrite(TB_RED, HIGH);
        digitalWrite(TB_YELLOW, LOW);
        digitalWrite(TB_GREEN, LOW);

        digitalWrite(TA_RED, HIGH);
        delay(1000);

        digitalWrite(TA_RED, LOW);
        digitalWrite(TA_YELLOW, HIGH);
        delay(1000);

        digitalWrite(TA_YELLOW, LOW);
        digitalWrite(TA_GREEN, HIGH);
        delay(1000);
        digitalWrite(TA_GREEN, LOW);

        direct = 2;
    } else if (direct == 2) {
        // Change TA
        digitalWrite(TA_RED, HIGH);
        digitalWrite(TA_YELLOW, LOW);
        digitalWrite(TA_GREEN, LOW);

        digitalWrite(TB_RED, HIGH);
        delay(1000);

        digitalWrite(TB_RED, LOW);
        digitalWrite(TB_YELLOW, HIGH);
        delay(1000);

        digitalWrite(TB_YELLOW, LOW);
        digitalWrite(TB_GREEN, HIGH);
        delay(1000);
        digitalWrite(TB_GREEN, LOW);

        direct = 1;
    }
}
