package repo.java.basis.atomicvariables;

public class SynchronizedCounter implements Counter {
    private volatile int value;

    @Override
    public synchronized void increase() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
