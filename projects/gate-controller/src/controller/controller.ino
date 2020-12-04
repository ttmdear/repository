#include <VirtualWire.h>

#define PIN_CLOSE 2
#define PIN_OPEN 3
#define PIN_STOP 4
#define PIN_LIMIT_CLOSE 5
#define PIN_LIMIT_OPEN 6
#define PIN_MOVING_INDICATOR 7

#define PIN_CONTACTOR_CONVERTER 8
#define PIN_CONTACTOR_CLOSE 9
#define PIN_CONTACTOR_OPEN A0

#define PIN_SENSOR_OBSTACLE_SWITCH 12
#define PIN_SENSOR_OBSTACLE_SIGNAL 13

#define PIN_RF_RECEIVER 11
#define PIN_RF_RECEIVER_SIGNAL A1

class RemoteController {
private:
    uint8_t data[VW_MAX_MESSAGE_LEN];
    uint8_t dataLength = VW_MAX_MESSAGE_LEN;

    int pin;
    int signalPin;

    char command[VW_MAX_MESSAGE_LEN];
public:
    RemoteController(int pin, int signalPin);
    void process();
    bool isOpenCommand();
    bool isCloseCommand();
    bool isStopCommand();
    void clearCommand();
};

void debug(String label, String value) {
    Serial.print(label + ": ");Serial.println(value);
}

void debug(String label, int value) {
    Serial.print(label + ": ");Serial.println(value);
}

void debug(String label, bool value) {
    Serial.print(label + ": ");Serial.println(value);
}

struct PinIO {
    int close;
    int open;
    int stop;
    int limitClose;
    int limitOpen;
    int movingIndicator;
    int contactorConverter;
    int contactorClose;
    int contactorOpen;
    int sensorObstacleSwitch;
    int sensorObstacleSignal;
};

class GateController {
private:
    PinIO pio;
    RemoteController* rc;

    int state = STATE_INDEFINITE;

    void processIndefiniteState();
    void processOpennedState();
    void processOpeningState();
    void processClosedState();
    void processClosingState();
    void processStoppedState();

    bool isHigh(int pin);
    bool isMoving();
    bool isStopped();

    void setOnSensorObstacle();
    void setOffSensorObstacle();
    bool isObstacle();

    void setContactors(bool open, bool close);
    String resolveState(int state);
    void setOnMovingIndicator();
    void setOffMovingIndicator();
public:
    static const int STATE_INDEFINITE = 0;
    static const int STATE_OPENNED = 1;
    static const int STATE_OPENING = 2;
    static const int STATE_CLOSED = 3;
    static const int STATE_CLOSING = 4;
    static const int STATE_STOPPED = 5;

    GateController(PinIO pio, RemoteController* rc);
    ~GateController();

    void process();
};

GateController::GateController(PinIO pio, RemoteController* rc) : pio(pio), rc(rc) {
    pinMode(PIN_CLOSE, INPUT);
    pinMode(PIN_OPEN, INPUT);
    pinMode(PIN_STOP, INPUT);
    pinMode(PIN_LIMIT_CLOSE, INPUT);
    pinMode(PIN_LIMIT_OPEN, INPUT);
    pinMode(PIN_MOVING_INDICATOR, OUTPUT);
    pinMode(PIN_CONTACTOR_CONVERTER, OUTPUT);
    pinMode(PIN_CONTACTOR_CLOSE, OUTPUT);
    pinMode(PIN_CONTACTOR_OPEN, OUTPUT);
    pinMode(PIN_SENSOR_OBSTACLE_SWITCH, OUTPUT);
    pinMode(PIN_SENSOR_OBSTACLE_SIGNAL, INPUT);
    // this->pio = pio;
    // this->rc = rc;
}

GateController::~GateController() {
    // ...
}

String GateController::resolveState(int state) {
    switch(state) {
        case STATE_OPENNED: return "openned";
        case STATE_OPENING: return "opening";
        case STATE_CLOSED: return "closed";
        case STATE_CLOSING: return "closing";
        case STATE_STOPPED: return "stopped";
        default: return "indefinite";
    }
}

void GateController::setOnMovingIndicator() {
    digitalWrite(pio.movingIndicator, HIGH);
}

void GateController::setOffMovingIndicator() {
    digitalWrite(pio.movingIndicator, LOW);
}

bool GateController::isObstacle() {
    return !isHigh(pio.sensorObstacleSignal);
}

void GateController::setOnSensorObstacle() {
    digitalWrite(pio.sensorObstacleSwitch, HIGH);
}

void GateController::setOffSensorObstacle() {
    digitalWrite(pio.sensorObstacleSwitch, LOW);
}

bool GateController::isHigh(int pin) {
    return digitalRead(pin) == HIGH;
}

bool GateController::isStopped() {
    return state != STATE_STOPPED;
}

bool GateController::isMoving() {
    return state == STATE_OPENING || state == STATE_CLOSING;
}

void GateController::setContactors(bool open, bool close) {
    if (open || close) {
        digitalWrite(pio.contactorConverter, HIGH);
    } else {
        digitalWrite(pio.contactorConverter, LOW);
    }

    debug("contactorOpen", pio.contactorOpen);

    if (open) {
        digitalWrite(pio.contactorOpen, HIGH);
    } else {
        digitalWrite(pio.contactorOpen, LOW);
    }

    if (close) {
        digitalWrite(pio.contactorClose, HIGH);
    } else {
        digitalWrite(pio.contactorClose, LOW);
    }
}

void GateController::process() {
    rc->process();

    // debug("isHigh(pio.limitOpen)", isHigh(pio.limitOpen));
    // debug("isHigh(pio.limitClose)", isHigh(pio.limitClose));
    // debug("isHigh(pio.open)", isHigh(pio.open));
    // debug("isHigh(pio.close)", isHigh(pio.close));
    // debug("isHigh(pio.stop)", isHigh(pio.stop));

    if (isHigh(pio.limitOpen)) {
        state = STATE_OPENNED;
    } else if (isHigh(pio.limitClose)) {
        state = STATE_CLOSED;
    }

    if (state == STATE_OPENNED && !isHigh(pio.limitOpen)) {
        state = STATE_INDEFINITE;
    } else if (state == STATE_CLOSED && !isHigh(pio.limitClose)) {
        state = STATE_INDEFINITE;
    }

    if ((isHigh(pio.open) || rc->isOpenCommand()) && state != STATE_OPENNED) {
        state = STATE_OPENING;
    } else if ((isHigh(pio.close) || rc->isCloseCommand()) && state != STATE_CLOSED) {
        state = STATE_CLOSING;
    }

    if (isHigh(pio.stop) || rc->isStopCommand()) {
        state = STATE_STOPPED;
    }

    if (isMoving()) {
        setOnSensorObstacle();
    } else {
        setOffSensorObstacle();
    }

    if (isMoving() && isObstacle()) {
        state = STATE_STOPPED;
    }

    debug("state", resolveState(state));

    switch(state) {
        case STATE_OPENNED:
            processOpennedState();
            break;
        case STATE_OPENING:
            processOpeningState();
            break;
        case STATE_CLOSED:
            processClosedState();
            break;
        case STATE_CLOSING:
            processClosingState();
            break;
        case STATE_STOPPED:
            processStoppedState();
            break;
        default:
            processIndefiniteState();
            break;
    }

    if (isMoving()) {
        setOnMovingIndicator();
    } else {
        setOffMovingIndicator();
    }

    rc->clearCommand();
}

void GateController::processIndefiniteState() {
    setContactors(false, false);
}

void GateController::processOpennedState() {
    setContactors(false, false);
}

void GateController::processOpeningState() {
    setContactors(true, false);
}

void GateController::processClosedState() {
    setContactors(false, false);
}

void GateController::processClosingState() {
    setContactors(false, true);
}

void GateController::processStoppedState() {
    setContactors(false, false);
}

RemoteController::RemoteController(int pin, int signalPin) {
    pinMode(pin, INPUT);
    pinMode(pin, OUTPUT);

    vw_set_ptt_inverted(true);
    vw_set_rx_pin(pin);
    vw_setup(2000);

    vw_rx_start();

    this->pin = pin;
    this->signalPin = signalPin;
}

void RemoteController::process() {

    dataLength = VW_MAX_MESSAGE_LEN;

    if(vw_get_message(data, &dataLength)) {
        Serial.print("dataLength  ");Serial.println(dataLength);
        memset(command, 0, sizeof(command));

        for(int i = 0; i < dataLength; i++) {
            command[i] = data[i];
        }


        Serial.print("get ");Serial.println(command);
    }
}

bool RemoteController::isOpenCommand() {
    return strcmp(command, "open") == 0;
}

bool RemoteController::isCloseCommand() {
    return strcmp(command, "close") == 0;
}

bool RemoteController::isStopCommand() {
    return strcmp(command, "stop") == 0;
}

void RemoteController::clearCommand() {
    memset(command, 0, sizeof(command));
}

PinIO pio = {
    PIN_CLOSE,
    PIN_OPEN,
    PIN_STOP,
    PIN_LIMIT_CLOSE,
    PIN_LIMIT_OPEN,
    PIN_MOVING_INDICATOR,
    PIN_CONTACTOR_CONVERTER,
    PIN_CONTACTOR_CLOSE,
    PIN_CONTACTOR_OPEN,
    PIN_SENSOR_OBSTACLE_SWITCH,
    PIN_SENSOR_OBSTACLE_SIGNAL
};

RemoteController* remoteController;
GateController* gateController;

void setup() {
    Serial.begin(9600);

    remoteController = new RemoteController(PIN_RF_RECEIVER, PIN_RF_RECEIVER_SIGNAL);
    gateController = new GateController(pio, remoteController);
}

void loop() {
    Serial.println("--------- loop ---------");
    gateController->process();

    delay(1000);
}
