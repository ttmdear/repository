#ifndef LIGHT_GARDEN_CONTROLLER_BUS_H
#define LIGHT_GARDEN_CONTROLLER_BUS_H
#include <Arduino.h>

#define STATE_IDLE 0
#define STATE_READ 1
#define STATE_TRANSMIT 2
#define SIG_TIME 200

class Bus {
private:
    char state = 0;

    unsigned long time = 0;

    unsigned long transmitTime;
    unsigned long transmitBitAt;
    char transmitBitNo;
    char transmitByteNo;
    char transmitByteNoEnd;
    char transmitBytes[10];

    bool bit;
    unsigned long bitAt;
    unsigned long bitTime;
    unsigned char bitNo;

    char byteBuffer = 0b00000000;

    char messageNo = 0;
    char messages[10][10];
    char messagesNo = 0;
    unsigned char messagesFreeNo = 1;
    unsigned char messagesReadNo = 0;

    char busPin;
    char statePin;
    void processIdle();
    void processRead();
    void processTransmit();
    void transmit(char bytee);
    bool readBus();
    bool readState();
public:
    // 0 REQ_ADDR 234 - R (request address)
    // B ADDR 234 - A (akc message)
    // 345 UP 244 345 345 - A (akc message)
    // 0 ACT

    // 0 A 234 - A (akc message)

    // 01 ............... 1
    Bus(char busPin, char statePin);
    void setup();
    void process();
    void transmit(String addr, String cmd, String params);
};

#endif //LIGHT_GARDEN_CONTROLLER_BUS_H
