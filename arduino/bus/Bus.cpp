#include "Bus.h"

void dump(const char string[5], char i, int base);

void dump(const char* label, const String &s) {
    return;
    Serial.print(label);
    Serial.print(": ");
    Serial.println(s);
}

void dump(const char* label, char value) {
    return;
    Serial.print(label);
    Serial.print(": ");
    Serial.println(value);
}

void dump(const char* label, char value, int base) {
    return;
    Serial.print(label);
    Serial.print(": ");

    if (base == 2) {
        byte mask = 0b10000000;

        for(unsigned int i = 0; i < 8; i++) {
            if (mask & value) {
                Serial.print("1");
            } else {
                Serial.print("0");
            }

            mask = mask >> 1;
        }

        Serial.println();
    } else {
        Serial.println(value, base);
    }
}

Bus::Bus(char busPin, char statePin) {
    this->busPin = busPin;
    this->statePin = statePin;
}

void Bus::process() {
    if (state == STATE_TRANSMIT) {
        processTransmit();
    } else if (state == STATE_IDLE) {
        processIdle();
    } else if (state == STATE_READ) {
        processRead();
    }
}

void Bus::processIdle() {
    if (digitalRead(statePin)) {
        return;
    }

    noInterrupts();
    bitAt = micros();
    bit = digitalRead(busPin);
    bitTime = 0;
    bitNo = 0;

    byteBuffer = 0b00000000;

    messageNo = 0;
    state = STATE_READ;
    interrupts();
}

void Bus::processRead() {
    unsigned long sampleAt = micros();
    bool sample = digitalRead(busPin);
    unsigned long diff = sampleAt - bitAt;

    if (diff >= (SIG_TIME - 20) && diff <= (SIG_TIME + 20)) {
        if (bit) {
            byteBuffer = byteBuffer | (0b10000000 >> bitNo);
            Serial.print('1');
        } else {
            Serial.print('0');
        }

        bitNo++;
        bitAt = bitAt + SIG_TIME;
        bitTime = bitTime - SIG_TIME;

        if (bitNo == 8) {
//            Serial.println("b8");
            // messages[messagesNo][messageNo] = byteBuffer;
            messages[0][0] = byteBuffer;
            byteBuffer = 0b00000000;
            messageNo++;
        }
    }

    if (bit != sample) {
        bit = sample;
        bitTime = 0;
        bitAt = sampleAt;
    }

    if (digitalRead(statePin) == HIGH) {
        messagesNo++;
        state = STATE_IDLE;
        // Serial.println(messages[0][0], 2);
        Serial.println(messages[0][0]);
    }
}

void Bus::processTransmit() {
    unsigned long time = micros();
    unsigned long delta = time - transmitBitAt;

    if (delta >= SIG_TIME) {
        transmitBitNo++;

        if (transmitBitNo == 8) {
            transmitByteNo++;
            transmitBitNo = 0;
        }

        if (transmitByteNo > transmitByteNoEnd) {
            digitalWrite(busPin, HIGH);
            pinMode(busPin, INPUT);

            digitalWrite(statePin, HIGH);
            pinMode(statePin, INPUT);

            state = STATE_IDLE;
            return;
        }

        transmitBitAt = time;

        if (transmitBytes[transmitByteNo] & (0b10000000 >> transmitBitNo)) {
            digitalWrite(busPin, HIGH);
        } else {
            digitalWrite(busPin, LOW);
        }
    }
}

void Bus::transmit(String addr, String cmd, String params) {
    noInterrupts();
    pinMode(statePin, OUTPUT);
    pinMode(busPin, OUTPUT);

    transmitTime = micros();
    transmitBitAt = transmitTime;
    transmitBitNo = 0;
    transmitByteNo = 0;
    transmitByteNoEnd = 0;
    transmitBytes[0] = 0b00001100;

    if (transmitBytes[transmitByteNo] & (0b10000000 >> transmitBitNo)) {
//        Serial.print('1');
        digitalWrite(busPin, HIGH);
    } else {
//        Serial.print('0');
        digitalWrite(busPin, LOW);
    }

    state = STATE_TRANSMIT;
    interrupts();
}

//void Bus::transmit(String addr, String cmd, String params) {
//    state = STATE_TRANSMIT;
//    pinMode(statePin, OUTPUT);
//    pinMode(busPin, OUTPUT);
//
//    for(unsigned int i = 0; i < addr.length(); i++) {
//        transmit(addr.charAt(i));
//    }
//
//    pinMode(busPin, INPUT);
//    pinMode(statePin, INPUT);
//    state = STATE_IDLE;
//}
//
//void Bus::transmit(char bytee) {
//    byte mask = 0b10000000;
//
//    for(int i = 0; i < 8; i++) {
//        if (bytee & mask) {
//            digitalWrite(busPin, HIGH);
//        } else {
//            digitalWrite(busPin, LOW);
//        }
//
//        delayMicroseconds(SIG_TIME);
//
//        mask = mask >> 1;
//    }
//}

void Bus::setup() {
    pinMode(busPin, INPUT);
    pinMode(statePin, INPUT);
}
