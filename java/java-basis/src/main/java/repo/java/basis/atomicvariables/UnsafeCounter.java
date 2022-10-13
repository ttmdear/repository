package repo.java.basis.atomicvariables;

public class UnsafeCounter implements Counter {
    private int value;

    @Override
    public synchronized void increase() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
