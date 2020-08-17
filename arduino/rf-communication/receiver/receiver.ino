#include <VirtualWire.h>

#define listyResetPin 8   // 14 nóżka µC
#define listyLedPin 9     // 15 nóżka µC

#define DIODE_PIN 3

boolean noweListy = false;

void setup() {
    vw_set_ptt_inverted(true);
    vw_setup(2000);

    vw_rx_start();

    Serial.begin(9600);
    pinMode(DIODE_PIN, OUTPUT);
    // pinMode(listyResetPin, INPUT_PULLUP);
}

void loop() {
    digitalWrite(DIODE_PIN, LOW);

    uint8_t odebrano[VW_MAX_MESSAGE_LEN];
    uint8_t dlugosc = VW_MAX_MESSAGE_LEN;

    if(vw_get_message(odebrano, &dlugosc)) {
        String wiadomosc;
        int i;

        for(i = 0; i < dlugosc; i++) {wiadomosc += char(odebrano[i]);}

        if (wiadomosc == "test") {
            digitalWrite(DIODE_PIN, HIGH);
        }

        Serial.print("Wiadomosc " + wiadomosc);

        // if(wiadomosc == "listy") {noweListy = true;}
        // if(wiadomosc == "pusto") {noweListy = false;}
    }

    delay(5000);
    // if(digitalRead(listyResetPin)==LOW) {noweListy = false;}

    // if(noweListy == true) {digitalWrite(listyLedPin, HIGH);}
    // else                  {digitalWrite(listyLedPin, LOW);}
}
