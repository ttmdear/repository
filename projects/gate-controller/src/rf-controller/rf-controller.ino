#include <VirtualWire.h>
#include <VirtualWire_Config.h>

#define PIN_CLOSE 2
#define PIN_OPEN 3
#define PIN_STOP 4

const char* COMMAND_OPEN = "open";
const char* COMMAND_CLOSE = "close";
const char* COMMAND_STOP = "stop";

void setup() {
    vw_set_ptt_inverted(true);
    vw_setup(2000);

    Serial.begin(9600); // open the serial port at 9600 bps:
}

void loop() {
    if (digitalRead(PIN_OPEN) == HIGH) {
        sendCommand(COMMAND_OPEN);
    } else if (digitalRead(PIN_CLOSE) == HIGH) {
        sendCommand(COMMAND_CLOSE);
    } else if (digitalRead(PIN_STOP) == HIGH) {
        sendCommand(COMMAND_STOP);
    }

    delay(1000);
}


void sendCommand(const char* const command) {
    Serial.print("sendCommand");Serial.println(command);

    vw_send((uint8_t *)command, strlen(command));
    vw_wait_tx();
}
