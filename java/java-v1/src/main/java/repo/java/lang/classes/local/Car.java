package repo.java.lang.classes.local;

public class Car {
    public void turn(TurnParams turnParams) {
        System.out.printf("turn %s, with speed %s%n", turnParams.getDirection(), turnParams.getSpeed());
    }

    public static class TurnParams {
        private int speed;
        private int direction;

        public TurnParams() {

        }

        public int getSpeed() {
            return speed;
        }

        public int getDirection() {
            return direction;
        }
    }
}
