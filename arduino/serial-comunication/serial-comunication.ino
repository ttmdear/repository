void setup() {
    Serial.begin(9600);
    Serial.setTimeout(5000);
}

void loop() {
    Serial.flush();

    while(Serial.available() == 0) {
        delay(500);
    }

    Serial.print("Dlugosc: ");
    Serial.println(Serial.available());

    // // // String
    // if (Serial.available()) {
    //     String command;

    //     command = Serial.readString();

    //     Serial.println(command);

    //     if (command == "go\n") {
    //         // ...
    //         Serial.println("Do A");
    //     } else {
    //         // ...
    //         Serial.println("Do B");
    //     }
    // }

    // if (Serial.available()) {
    //     String command;

    //     command = Serial.readStringUntil('g');

    //     Serial.println(command);
    // }

    // while(Serial.available()) {
    //     int c;

    //     c = Serial.read();

    //     Serial.println(c, DEC);
    //     Serial.println(c, HEX);
    //     Serial.println("-----"
    // }

    // if (Serial.available()) {
    //     double input;

    //     input = Serial.parseFloat();

    //     Serial.println(input);
    // }

    if (Serial.available()) {
        int input;

        input = Serial.parseInt();

        Serial.println(input);
    }
}
