package repo.java.lang.interfaces.case1;

public interface Moveable {
    MoveResult move();

    default void logActivity() {
        // ...
    }

    default void moveStart() {
        move();
    }

    class MoveResult {
        public int number;

        public MoveResult(int number) {
            this.number = number;
        }
    }
}
