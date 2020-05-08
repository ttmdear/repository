#include <Servo.h> //Biblioteka odpowiedzialna za serwa

#define BLUE 2
#define PINK 3
#define YELLOW 4
#define ORANGE 5

class PwmController {
    private:

    /**
     * Ostatni pomiar czasu od rozpoczecia cyklu
     */
    unsigned long lastTime;

    /**
     * Wypełnienie
     */
    unsigned long fulfillment;

    unsigned long t;

    /**
     * Aktualny poziom
     */
    bool level;

    /**
     * Pin wyjściowy
     */
    int pin;

    public:

    PwmController(int pin, long frequency);

    void reload();
    void start();
    void setFulfillment(unsigned long fulfillment); void setFrequency(long frequency);
    void generateWithBlock(unsigned int h, unsigned t);

};

PwmController::PwmController(int pin, long frequency) {
    pinMode(pin, OUTPUT);

    this->pin = pin;

    setFrequency(frequency);
}

void PwmController::setFrequency(long frequency) {
    t = (1 / frequency) * 1000000;
}

void PwmController::setFulfillment(unsigned long fulfillment) {
    this->fulfillment = fulfillment;
}

void PwmController::reload() {
    unsigned long time = micros();

    Serial.print("time: ");Serial.println(time);
    Serial.print("lastTime: ");Serial.println(lastTime);
    Serial.print("fulfillment: ");Serial.println(fulfillment);
    Serial.print("time: ");Serial.println(time);

    if (level == 1) {
        if (time >= lastTime + fulfillment) {
            level = 0;
        }
    } else {
        if (time >= lastTime + t) {
            lastTime = micros();
            level = 1;
        }

    }

    if (level == 0) {
        digitalWrite(pin, LOW);
    } else {
        digitalWrite(pin, HIGH);
    }
}

void PwmController::generateWithBlock(unsigned int h, unsigned t) {
    digitalWrite(pin, LOW);
    delayMicroseconds(100);

    digitalWrite(pin, HIGH);

    delayMicroseconds(h);

    digitalWrite(pin, LOW);

    delayMicroseconds(20000 - h);
    digitalWrite(pin, HIGH);
}

void PwmController::start() {
    // Set level UP
    level = 1;

    // Get last time
    lastTime = micros();
}

PwmController controller(3, 50);

Servo serwomechanizm;  //Tworzymy obiekt, dzięki któremu możemy odwołać się do serwa

int pozycja = 0; //Aktualna pozycja serwa 0-180
int zmiana = 6; //Co ile ma się zmieniać pozycja serwa?

void setup() {
    // Serial.begin(9600); // open the serial port at 9600 bps:

    controller.start();
    controller.setFulfillment(1000);

    pinMode(BLUE, OUTPUT);
    pinMode(PINK, OUTPUT);
    pinMode(YELLOW, OUTPUT);
    pinMode(ORANGE, OUTPUT);
    // serwomechanizm.attach(3);
}

void signal(int pin) {

    digitalWrite(pin, HIGH);

    delayMicroseconds(1000);

    digitalWrite(pin, LOW);
    delayMicroseconds(1000);
}

void loop() {
    // controller.reload();
    int d = 5;

    // 2
    digitalWrite(ORANGE, HIGH);
    digitalWrite(YELLOW, HIGH);
    digitalWrite(PINK, LOW);
    digitalWrite(BLUE, LOW);
    delay(d);

    // 3
    digitalWrite(ORANGE, LOW);
    digitalWrite(YELLOW, HIGH);
    digitalWrite(PINK, LOW);
    digitalWrite(BLUE, LOW);
    delay(d);

    // 4
    digitalWrite(ORANGE, LOW);
    digitalWrite(YELLOW, HIGH);
    digitalWrite(PINK, HIGH);
    digitalWrite(BLUE, LOW);
    delay(d);

    // 5
    digitalWrite(ORANGE, LOW);
    digitalWrite(YELLOW, LOW);
    digitalWrite(PINK, HIGH);
    digitalWrite(BLUE, LOW);
    delay(d);

    // 6
    digitalWrite(ORANGE, LOW);
    digitalWrite(YELLOW, LOW);
    digitalWrite(PINK, HIGH);
    digitalWrite(BLUE, HIGH);
    delay(d);

    // 7
    digitalWrite(ORANGE, LOW);
    digitalWrite(YELLOW, LOW);
    digitalWrite(PINK, LOW);
    digitalWrite(BLUE, HIGH);
    delay(d);

    // 8
    digitalWrite(ORANGE, HIGH);
    digitalWrite(YELLOW, LOW);
    digitalWrite(PINK, LOW);
    digitalWrite(BLUE, HIGH);
    delay(d);

    // 1
    digitalWrite(ORANGE, HIGH);
    digitalWrite(YELLOW, LOW);
    digitalWrite(PINK, LOW);
    digitalWrite(BLUE, LOW);

    delay(d);

}
