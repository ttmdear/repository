# define PIN_DS 4 // Wejście danych
# define PIN_ST_CP 2 // Przenosi z na OUTPUT
# define PIN_SH_CP 3 // SH_CP Wsuwa bity a R_DS

// class DiodesDisplay {
//     int pinDS;
//     int pinOutputEnable;
//     int pinSTCP;
//     int pinSHCP;
//     int pinMR;
//     int last = 0;
//
//     float value = 0;
//     float valuePrepared[4] = {0, 0, 0, 0};
//
//     byte segmentsCharMaps[10] = {
//         B11010111,
//         B01010000,
//         B11100110,
//         B11110100,
//         B01110001,
//         B10110101,
//         B10110111,
//         B11010000,
//         B11110111,
//         B11110101,
//     };
//
//     public:
//
//     DiodesDisplay(int pinDS, int pinOutputEnable, int pinSTCP, int pinSHCP, int pinMR) {
//         this->pinDS = pinDS;
//         this->pinOutputEnable = pinOutputEnable;
//         this->pinSTCP = pinSTCP;
//         this->pinSHCP = pinSHCP;
//         this->pinMR = pinMR;
//     }
//
//     byte getBytesSequenceForNumber(int number, bool zeroAsNo = 0, bool dot = 0) {
//         byte data = B00000000;
//
//         if (number == 0) {
//             if (zeroAsNo) {
//                 data = B00000000;
//             } else {
//                 data = B11010111;
//             }
//         } else {
//             data = segmentsCharMaps[number];
//         }
//
//         if (dot) {
//             data = data | B00001000;
//         }
//
//         return ~data;
//     }
//
//     void display(float value, int delayValue = 0) {
//
//         if (this->value != value) {
//             // Recount value
//
//             int valueInteger = 100 * value;
//
//             int a = valueInteger % 10;
//
//             int b = (valueInteger - a) % 100;
//             int c = (valueInteger - a - b) % 1000;
//             int d = (valueInteger - a - b - d) % 10000;
//
//             // a = a / 10;
//             b = b / 10;
//             c = c / 100;
//             d = d / 1000;
//
//             valuePrepared[0] = d;
//             valuePrepared[1] = c;
//             valuePrepared[2] = b;
//             valuePrepared[3] = a;
//
//             this->value = value;
//         }
//
//
//         digitalWrite(pinMR, HIGH);
//         digitalWrite(pinOutputEnable, LOW);
//
//         for(int i = 0; i < 4; i++) {
//             digitalWrite(R_ST_CP, LOW);
//
//             if (delayValue > 200) {
//                 delay(1000);
//             } else if (delayValue > 400) {
//                 delay(2000);
//             } else if (delayValue > 600) {
//                 delay(3000);
//             } else if (delayValue > 800) {
//                 delay(4000);
//             } else if (delayValue > 1000) {
//                 delay(5000);
//             }
//
//             if (i == 0) {
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, ~B10000000);
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i], 1));
//             } else if (i == 1) {
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, ~B01000000);
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i], 0, 1));
//             } else if (i == 2) {
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00100000);
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i]));
//             } else if (i == 3) {
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00010000);
//                 shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i]));
//             }
//
//             digitalWrite(R_ST_CP, HIGH);
//
//             // digitalWrite(R_ST_CP, LOW);
//
//             // shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00000000);
//             // shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00000000);
//
//             // digitalWrite(R_ST_CP, HIGH);
//         }
//     }
// };

//
void setup() {
    // Serial.begin(9600);

    pinMode(PIN_DS, OUTPUT);
    pinMode(PIN_SH_CP, OUTPUT);
    // pinMode(R_MR, OUTPUT);
    pinMode(PIN_ST_CP, OUTPUT);
    // pinMode(R_OUTPUT_ENABLE, OUTPUT);
    // pinMode(TEMPERATURE_INPUT, INPUT);
    // pinMode(INTERNAL_INPUT, INPUT);
    // pinMode(LED_BUILTIN, OUTPUT);

    // DEFAULT: the default analog reference of 5 volts (on 5V Arduino boards) or 3.3 volts (on 3.3V Arduino boards)
    // INTERNAL: an built-in reference, equal to 1.1 volts on the ATmega168 or ATmega328P and 2.56 volts on the ATmega32U4 and ATmega8 (not available on the Arduino Mega)
    // INTERNAL1V1: a built-in 1.1V reference (Arduino Mega only)
    // INTERNAL2V56: a built-in 2.56V reference (Arduino Mega only)
    // EXTERNAL: the voltage applied to the AREF pin (0 to 5V only) is used as the reference.
    // analogReference(INTERNAL);
}

// DiodesDisplay* diodesDisplay = new DiodesDisplay(R_DS, R_OUTPUT_ENABLE, R_ST_CP, R_SH_CP, R_MR);
//
// double lastC = 0;
// int delayInt = 0;
// bool diode = HIGH;
//
// double temperatureReadDelay = 1001;
// double temperature = 0;
// double temperatureLast = 0;
//
// double intervalAnalog = 0;
// double intervalReadDelay = 10;

int pointer = 0;
unsigned long time = millis();

void loop() {
    if (millis() - time > 10) {
        time = millis();
        render();
    }

    // delay(10);
    // render();
}

bool bitmap[15][8] = {
    /* 00 */ {1, 0, 0, 0, 0, 0, 0, 0},
    /* 01 */ {0, 1, 0, 0, 0, 0, 1, 0},
    /* 02 */ {0, 1, 1, 0, 0, 0, 1, 0},
    /* 03 */ {0, 1, 0, 1, 0, 0, 1, 0},
    /* 04 */ {0, 1, 0, 0, 1, 0, 1, 0},
    /* 05 */ {0, 1, 0, 0, 0, 1, 1, 0},
    /* 06 */ {0, 1, 0, 0, 0, 0, 1, 0},
    /* 07 */ {0, 1, 0, 0, 0, 0, 1, 1},
    /* 08 */ {0, 1, 0, 0, 0, 0, 1, 0},
    /* 09 */ {0, 1, 0, 0, 0, 1, 1, 0},
    /* 10 */ {0, 1, 0, 0, 1, 0, 1, 0},
    /* 11 */ {0, 1, 0, 1, 0, 0, 1, 0},
    /* 12 */ {0, 1, 1, 0, 0, 0, 1, 0},
    /* 13 */ {0, 1, 0, 0, 0, 0, 1, 0},
    /* 14 */ {1, 0, 0, 0, 0, 0, 0, 0}
};

void swipe() {
    int first[8];

    // for(int i = 0; i < 8, i++) firt[i] = bitmap[0][i];



}


void render() {
    // // 10000000 00000000 1111111 0

    // digitalWrite(PIN_ST_CP, LOW);

    // shiftOut(PIN_DS, PIN_SH_CP, LSBFIRST, B00000000);
    // shiftOut(PIN_DS, PIN_SH_CP, LSBFIRST, B00000000);
    // shiftOut(PIN_DS, PIN_SH_CP, LSBFIRST, B00000000);

    // shiftOut(PIN_DS, PIN_SH_CP, LSBFIRST, B01111110);
    // shiftOut(PIN_DS, PIN_SH_CP, LSBFIRST, B00000001);
    // shiftOut(PIN_DS, PIN_SH_CP, LSBFIRST, B01000000);

    // digitalWrite(PIN_ST_CP, HIGH);

    // delay(5000);
    // return;

    //
    bool row[8];
    bool output[23];

    for(int i=0; i<15; i++) {
        // delay(40);
        // output[i] = 0;

        // if (pointer == i) {
        //     output[i] = 1;

        //     for(int j=0; j<8; j++)
        //         row[j] = !bitmap[i][j];
        // }

        output[0] = 0;
        output[1] = 0;
        output[2] = 0;
        output[3] = 0;
        output[4] = 0;
        output[5] = 0;
        output[6] = 0;
        output[7] = 0;
        output[8] = 0;
        output[9] = 0;
        output[10] = 0;
        output[11] = 0;
        output[12] = 0;
        output[13] = 0;
        output[14] = 0;
        output[15] = 0;
        output[16] = 0;
        output[17] = 0;
        output[18] = 0;
        output[19] = 0;
        output[20] = 0;
        output[21] = 0;
        output[22] = 0;

        output[i] = 1;

        for(int j=0; j<8; j++)
            output[15 + j] = !bitmap[i][j];


        digitalWrite(PIN_ST_CP, LOW);

        for(int i = 22; i >= 0; i--) {
            digitalWrite(PIN_DS, LOW);

            digitalWrite(PIN_SH_CP, HIGH);
            digitalWrite(PIN_SH_CP, LOW);
        }

        for(int i = 22; i >= 0; i--) {
            digitalWrite(PIN_DS, output[i] ? HIGH : LOW);

            digitalWrite(PIN_SH_CP, HIGH);
            digitalWrite(PIN_SH_CP, LOW);
        }

        digitalWrite(PIN_ST_CP, HIGH);
    }

    // pointer++;

    // if (pointer >= 15) {
    //     pointer = 0;
    // }

    // for(int i=0; i<8; i++) {
    //     output[15 + i] = row[i];
    // }

}
