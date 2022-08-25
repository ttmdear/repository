package repo.java.basis;

public class Scope {
    public static void print(String format, Object ... args) {
        System.out.printf(format + "%n", args);
    }
}
