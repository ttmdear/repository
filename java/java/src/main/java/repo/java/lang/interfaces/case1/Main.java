package repo.java.lang.interfaces.case1;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Moveable.MoveResult result = user.move();

        System.out.printf("result " + result.number);
    }
}
