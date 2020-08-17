#include <Wire.h>

void setup() {
    Wire.begin();

    Serial.begin(9600);
}

#define ADDR 0x21

void loop() {

    //  010 0000 - 0x20
    //  010 0001 - 0x21
    //       ---

    Wire.requestFrom(ADDR, 1);

    while(Wire.available()) {
        byte response = Wire.read();

        byte request = response >> 4;

        // Wire.beginTransmission(32);
        Wire.beginTransmission(ADDR);

        Wire.write(request);

        Wire.endTransmission();

        // Serial.print("response ");Serial.println(response, BIN);
    }

    // byte request = response << 4;

    // Wire.write(request);

    // // Wire.write(byte(0x00));
    // // Wire.write(byte(0x05));
    // // Wire.write(B00000000);
    // Wire.endTransmission();

    delay(5000);
}
