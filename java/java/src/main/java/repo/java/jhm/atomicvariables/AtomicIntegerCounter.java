package repo.java.jhm.atomicvariables;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements Counter {
    private AtomicInteger value = new AtomicInteger();

    @Override
    public void increase() {
        value.incrementAndGet();
    }

    @Override
    public int getValue() {
        return value.intValue();
    }
}
