package repo.java.variables;

public class App {
    public static void main(String[] args) {
        int INT;

        if (resolve() || true) {
            INT = 1;
        }

        System.out.println("Test " + INT);
    }

    private static boolean resolve() {
        return true;
    }
}
