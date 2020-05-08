# define R_DS 8 // Wejście danych
# define R_OUTPUT_ENABLE 9 // Przenosi z na OUTPUT
# define R_ST_CP 10 // Przenosi z na OUTPUT
# define R_SH_CP 11 // SH_CP Wsuwa bity a R_DS
# define R_MR 12 // Resetuje bity
# define TEMPERATURE_INPUT A1
# define INTERNAL_INPUT A1

class DiodesDisplay {
    int pinDS;
    int pinOutputEnable;
    int pinSTCP;
    int pinSHCP;
    int pinMR;
    int last = 0;

    float value = 0;
    float valuePrepared[4] = {0, 0, 0, 0};

    byte segmentsCharMaps[10] = {
        B11010111,
        B01010000,
        B11100110,
        B11110100,
        B01110001,
        B10110101,
        B10110111,
        B11010000,
        B11110111,
        B11110101,
    };

    public:

    DiodesDisplay(int pinDS, int pinOutputEnable, int pinSTCP, int pinSHCP, int pinMR) {
        this->pinDS = pinDS;
        this->pinOutputEnable = pinOutputEnable;
        this->pinSTCP = pinSTCP;
        this->pinSHCP = pinSHCP;
        this->pinMR = pinMR;
    }

    byte getBytesSequenceForNumber(int number, bool zeroAsNo = 0, bool dot = 0) {
        byte data = B00000000;

        if (number == 0) {
            if (zeroAsNo) {
                data = B00000000;
            } else {
                data = B11010111;
            }
        } else {
            data = segmentsCharMaps[number];
        }

        if (dot) {
            data = data | B00001000;
        }

        return ~data;
    }

    void display(float value, int delayValue = 0) {

        if (this->value != value) {
            // Recount value

            int valueInteger = 100 * value;

            int a = valueInteger % 10;

            int b = (valueInteger - a) % 100;
            int c = (valueInteger - a - b) % 1000;
            int d = (valueInteger - a - b - d) % 10000;

            // a = a / 10;
            b = b / 10;
            c = c / 100;
            d = d / 1000;

            valuePrepared[0] = d;
            valuePrepared[1] = c;
            valuePrepared[2] = b;
            valuePrepared[3] = a;

            this->value = value;
        }


        digitalWrite(pinMR, HIGH);
        digitalWrite(pinOutputEnable, LOW);

        for(int i = 0; i < 4; i++) {
            digitalWrite(R_ST_CP, LOW);

            if (delayValue > 200) {
                delay(1000);
            } else if (delayValue > 400) {
                delay(2000);
            } else if (delayValue > 600) {
                delay(3000);
            } else if (delayValue > 800) {
                delay(4000);
            } else if (delayValue > 1000) {
                delay(5000);
            }

            if (i == 0) {
                shiftOut(pinDS, pinSHCP, LSBFIRST, ~B10000000);
                shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i], 1));
            } else if (i == 1) {
                shiftOut(pinDS, pinSHCP, LSBFIRST, ~B01000000);
                shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i], 0, 1));
            } else if (i == 2) {
                shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00100000);
                shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i]));
            } else if (i == 3) {
                shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00010000);
                shiftOut(pinDS, pinSHCP, LSBFIRST, getBytesSequenceForNumber(valuePrepared[i]));
            }

            digitalWrite(R_ST_CP, HIGH);

            // digitalWrite(R_ST_CP, LOW);

            // shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00000000);
            // shiftOut(pinDS, pinSHCP, LSBFIRST, ~B00000000);

            // digitalWrite(R_ST_CP, HIGH);
        }
    }
};

//
void setup() {
    Serial.begin(9600);

    pinMode(R_DS, OUTPUT);
    pinMode(R_SH_CP, OUTPUT);
    pinMode(R_MR, OUTPUT);
    pinMode(R_ST_CP, OUTPUT);
    pinMode(R_OUTPUT_ENABLE, OUTPUT);
    pinMode(TEMPERATURE_INPUT, INPUT);
    pinMode(INTERNAL_INPUT, INPUT);
    // pinMode(LED_BUILTIN, OUTPUT);

    // DEFAULT: the default analog reference of 5 volts (on 5V Arduino boards) or 3.3 volts (on 3.3V Arduino boards)
    // INTERNAL: an built-in reference, equal to 1.1 volts on the ATmega168 or ATmega328P and 2.56 volts on the ATmega32U4 and ATmega8 (not available on the Arduino Mega)
    // INTERNAL1V1: a built-in 1.1V reference (Arduino Mega only)
    // INTERNAL2V56: a built-in 2.56V reference (Arduino Mega only)
    // EXTERNAL: the voltage applied to the AREF pin (0 to 5V only) is used as the reference.
    analogReference(INTERNAL);
}

DiodesDisplay* diodesDisplay = new DiodesDisplay(R_DS, R_OUTPUT_ENABLE, R_ST_CP, R_SH_CP, R_MR);

double lastC = 0;
int delayInt = 0;
bool diode = HIGH;

double temperatureReadDelay = 1001;
double temperature = 0;
double temperatureLast = 0;

double intervalAnalog = 0;
double intervalReadDelay = 10;

void loop() {
    if (temperatureReadDelay > 1000) {

        double temperatureAnalog = analogRead(TEMPERATURE_INPUT);

        // Serial.println("temperatureVoltage: " + temperatureAnalog);

        // double temperature = analogRead(TEMPERATURE_INPUT) * 0.0048;

        // double temperatureVoltage = temperatureAnalog * 0.001074;
        // double temperatureVoltage = temperatureAnalog * 0.001074;
        // double temperatureVoltage = temperatureAnalog * 0.0048828125;
        double temperatureVoltage = temperatureAnalog * 0.00107421875;
        // double temperatureVoltage = temperatureAnalog * 0.004560;
        // double temperatureVoltage = temperatureAnalog * 0.00322265625;

        // double temperatureVoltage = temperatureAnalog * 0.0025;
        // double temperatureVoltage = temperatureAnalog * 0.010;
        // double temperatureVoltage = temperatureAnalog * 0.0048;

        // double temperatura = ((analogRead(TEMPERATURE_INPUT) * 5.0) / 1024.0) * 100;

        Serial.print("temperatureAnalog: "); Serial.println(temperatureAnalog);
        Serial.print("temperatureVoltage: "); Serial.println(temperatureVoltage);

        // temperature = (analogRead(TEMPERATURE_INPUT) * 0.0010) * 100;
        temperature = temperatureVoltage * 100;

        float temperatura = analogRead(TEMPERATURE_INPUT); //Odczytanie napięcia z czujnika temperatury
        temperatura = temperatura * 0.48828125; //Wyznaczenie temperatury

        Serial.print("temperatura: "); Serial.println(temperatura);
        Serial.print("temperature: "); Serial.println(temperature);

        temperatureReadDelay = 0;

        if (abs(temperatureLast - temperature) > 0.5) {
            temperatureLast = temperature;
        }
    }

    temperatureReadDelay++;

    // // if (intervalReadDelay > 10) {
    //     intervalAnalog = analogRead(INTERNAL_INPUT);

    //     // intervalReadDelay = 0;
    // // }

    // intervalReadDelay++;

    // if (intervalAnalog > 100 && intervalAnalog < 1000) {
    // diodesDisplay->display(temperatureLast, intervalAnalog);
    diodesDisplay->display(temperatureLast);
    // } else {
    //     diodesDisplay->display(temperatureLast);
    // }


    // Serial.print("intervalAnalog");
    // Serial.println(intervalAnalog);

}
