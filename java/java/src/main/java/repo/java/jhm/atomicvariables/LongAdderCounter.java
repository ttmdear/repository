package repo.java.jhm.atomicvariables;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounter implements Counter {
    private final LongAdder value = new LongAdder();

    @Override
    public void increase() {
        value.increment();
    }

    @Override
    public int getValue() {
        return value.intValue();
    }
}
