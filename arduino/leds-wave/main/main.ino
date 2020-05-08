
void setup() {
  Serial.begin(9600); // open the serial port at 9600 bps:

  // pinMode(RESISTOR, INPUT);
}

void loop() {
  Serial.print("loop");
  Serial.println();

  Serial.println(analogRead(A1));
  
  delay(1000);

}
