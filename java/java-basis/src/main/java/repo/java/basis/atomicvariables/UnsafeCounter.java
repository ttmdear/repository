package repo.java.basis.atomicvariables;

public class UnsafeCounter implements Counter {
    private volatile int value;

    @Override
    public void increase() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
