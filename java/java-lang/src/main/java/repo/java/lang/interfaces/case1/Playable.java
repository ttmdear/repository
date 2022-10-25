package repo.java.lang.interfaces.case1;

public interface Playable {

    void play();

    default void logActivity() {
        // ...
    }

    class PlayResult {

    }

    public static class PlayResult2 {

    }
}
