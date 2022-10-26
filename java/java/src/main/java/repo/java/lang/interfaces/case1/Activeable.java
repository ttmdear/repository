package repo.java.lang.interfaces.case1;

public interface Activeable extends Moveable, Playable {

    @Override
    default void logActivity() {
        Moveable.super.logActivity();
    }
}
