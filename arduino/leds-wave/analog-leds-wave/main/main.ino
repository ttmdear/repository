void setup() {
  // put your setup code here, to run once:
  pinMode(3, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
}

int delayValue = 10;
void loop() {
  // put your main code here, to run repeatedly:

  for(int i=255; i > 0; i--) {
    analogWrite(3, i);
    delay(delayValue);
  }

   for(int i=0; i < 255; i++) {
    analogWrite(3, i);
    delay(delayValue);
  }
}
