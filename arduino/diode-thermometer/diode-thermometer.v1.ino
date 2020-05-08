# define R_DS 8 // Wejście danych
# define R_OUTPUT_ENABLE 9 // Przenosi z na OUTPUT
# define R_ST_CP 10 // Przenosi z na OUTPUT
# define R_SH_CP 11 // SH_CP Wsuwa bity a R_DS
# define R_MR 12 // Resetuje bity
# define TEMPERATURE_INPUT A0

class DiodesDisplay {
    int pinDS;
    int pinOutputEnable;
    int pinSTCP;
    int pinSHCP;
    int pinMR;

    public:

    DiodesDisplay(int pinDS, int pinOutputEnable, int pinSTCP, int pinSHCP, int pinMR) {
        this->pinDS = pinDS;
        this->pinOutputEnable = pinOutputEnable;
        this->pinSTCP = pinSTCP;
        this->pinSHCP = pinSHCP;
        this->pinMR = pinMR;
    }

    void setLevel(int level) {
        digitalWrite(pinMR, HIGH);
        digitalWrite(pinOutputEnable, LOW);

        // 00000000 - 0
        // 10000000 - 1
        // 11000000 - 3
        // 11100000 - 7
        // 11110000 - 15
        // 11111000 - 31
        // 11111100 - 63
        // 11111110 - 127
        // 11111111 - 255

        digitalWrite(R_ST_CP, LOW);

        Serial.println(level);

        if (level <= 0) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 0);
        } else if (level <= 5) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 1);
        } else if (level <= 10) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 3);
        } else if (level <= 15) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 7);
        } else if (level <= 20) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 15);
        } else if (level <= 25) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 31);
        } else if (level <= 30) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 63);
        } else if (level <= 35) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 127);
        } else if (level > 35) {
            shiftOut(pinDS, pinSHCP, MSBFIRST, 255);
        }

        digitalWrite(R_ST_CP, HIGH);
    }
};

// //Pin connected to ST_CP of 74HC595
// int latchPin = 8;
// //Pin connected to SH_CP of 74HC595
// int clockPin = 12;
// ////Pin connected to DS of 74HC595
// int dataPin = 11;

void setup() {
    Serial.begin(9600);

    pinMode(R_DS, OUTPUT);
    pinMode(R_SH_CP, OUTPUT);
    pinMode(R_MR, OUTPUT);
    pinMode(R_ST_CP, OUTPUT);
    pinMode(R_OUTPUT_ENABLE, OUTPUT);
    pinMode(TEMPERATURE_INPUT, INPUT);

}

DiodesDisplay* diodesDisplay = new DiodesDisplay(R_DS, R_OUTPUT_ENABLE, R_ST_CP, R_SH_CP, R_MR);
int level = 0;

void loop() {

    Serial.println("loop");

    double v = analogRead(TEMPERATURE_INPUT) * 0.0048;

    // Watość jest np. 0.310V, mnożymy razy 10 aby uzuskać C.
    double c = v * 100;

    // Współczynnik zmiany to 10mV na 1 C. Czyli zmiana o 1C zwiększa
    // napięcie o 10mV.
    // Czyli jeśli mamy napięcie 30mV to oznacza, że temperatura jest równa
    // 30 C

    Serial.println(c);

    diodesDisplay->setLevel(c);


    delay(1000);
    // digitalWrite(R_SH_CP, LOW);
    // digitalWrite(R_ST_CP, LOW);

    // // // Put
    // digitalWrite(R_DS, HIGH);
    // delay(1000);
    // digitalWrite(R_SH_CP, HIGH);
    // delay(1000);
    // digitalWrite(R_ST_CP, HIGH);

    // delay(1000);

    // for (int j = 0; j < 256; j++) {
    //     //ground latchPin and hold low for as long as you are transmitting
    //     digitalWrite(R_ST_CP, LOW);

    //     // shiftOut(R_DS, R_SH_CP, LSBFIRST, j);
    //     shiftOut(R_DS, R_SH_CP, MSBFIRST, j);

    //     //return the latch pin high to signal chip that it
    //     //no longer needs to listen for information
    //     digitalWrite(R_ST_CP, HIGH);

    //     delay(5);
    // }
}
