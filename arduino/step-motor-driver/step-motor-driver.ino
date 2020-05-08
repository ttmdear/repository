#define C1 2
#define C2 3
#define C3 4
#define C4 5
#define STEPS_PER_ROUND 2048

#define MOVE_LEFT A0
#define MOVE_RIGHT A1
#define MOVE_DIODE 6
#define POSITION_INDICATOR A2

char strtemp[6];

class StepMotor {
private:
    int stepsPerRound;
    int c1;
    int c2;
    int c3;
    int c4;
    int stepsSequence[4][4] = {
        {1, 0, 0, 0},
        {0, 0, 0, 1},
        {0, 1, 0, 0},
        {0, 0, 1, 0},
    };
    int lastStep = 0;
public:
    StepMotor(int stepsPerRound, int c1, int c2, int c3, int c4);
    void move(int direct, int degree);
};

StepMotor::StepMotor(int stepsPerRound, int c1, int c2, int c3, int c4) {
    this->stepsPerRound = stepsPerRound;
    this->c1 = c1;
    this->c2 = c2;
    this->c3 = c3;
    this->c4 = c4;

    // Set pins mode
    pinMode(c1, OUTPUT);
    pinMode(c2, OUTPUT);
    pinMode(c3, OUTPUT);
    pinMode(c4, OUTPUT);
}

void printlnDouble(double value, int a=3, int p=3) {
    char str_temp[a+p];

    /* 4 is mininum width, 2 is precision; float value is copied onto str_temp*/
    dtostrf(value, a, p, str_temp);

    Serial.println(str_temp);
}

void StepMotor::move(int direct, int degree) {
    double stepsPerDegree = stepsPerRound / 360.00;

    int steps = degree * stepsPerDegree;

    int d = 3;

    while(steps >= 0) {
        int sequence = lastStep + direct;

        if (sequence < 0) {
            sequence = 3;
        } else if (sequence > 3) {
            sequence = 0;
        }

        digitalWrite(c1, stepsSequence[sequence][0]);
        digitalWrite(c2, stepsSequence[sequence][1]);
        digitalWrite(c3, stepsSequence[sequence][2]);
        digitalWrite(c4, stepsSequence[sequence][3]);

        delay(d);
        steps--;
        lastStep = sequence;
    }
}

void setup() {
    Serial.begin(9600); // open the serial port at 9600 bps:

    pinMode(MOVE_LEFT, INPUT);
    pinMode(MOVE_RIGHT, INPUT);
    pinMode(MOVE_DIODE, OUTPUT);
    pinMode(POSITION_INDICATOR, INPUT);
}

StepMotor stepMotor(STEPS_PER_ROUND, C1, C2, C3, C4);

bool isMoveLeftPressed() {
    return analogRead(MOVE_LEFT) > 100;
}

bool isMoveRightPressed() {
    return analogRead(MOVE_RIGHT) > 100;
}

int getPositionIndicatorAtDegree() {
    int positionIndicator = 1023 - analogRead(POSITION_INDICATOR);

    return map(positionIndicator, 0, 1023, 0, 360);
}

int positionDegree = 0;

long movingTimeout = millis();
bool movingActive = false;

void loop() {
    if (isMoveLeftPressed() || isMoveRightPressed()) {
        processSettingPosition();

        movingTimeout = millis();
        movingActive = true;
    }

    if (movingActive) {
        if (millis() - movingTimeout > 5000) {
            movingActive = false;
            positionDegree = 0;
        }
    }

    if (movingActive) {
        digitalWrite(MOVE_DIODE, HIGH);
    } else {
        digitalWrite(MOVE_DIODE, LOW);

        int positionDegreePresent = getPositionIndicatorAtDegree();

        if (abs(positionDegreePresent - positionDegree) > 2) {
            setPosition(positionDegreePresent);
        }

    }
}

void processSettingPosition() {
    while(isMoveLeftPressed()) {
        stepMotor.move(1, 10);
    }

    while(isMoveRightPressed()) {
        stepMotor.move(-1, 10);
    }
}

void setPosition(int degree) {
    int delta = positionDegree - degree;

    if (delta > 0) {
        stepMotor.move(1, delta);
    } else if (delta < 0) {
        stepMotor.move(-1, delta * -1);
    }

    positionDegree = degree;
}
