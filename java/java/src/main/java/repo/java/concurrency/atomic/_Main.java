package repo.java.concurrency.atomic;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class _Main {
    public static void main(String[] args) throws IOException {
        caseAtomicInteger();
    }

    private static void caseAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger();

        int before = atomicInteger.getAndSet(10);
        int before2 = atomicInteger.getAndSet(20);
        int acquire = atomicInteger.getAcquire();

        System.out.println(before);
        System.out.println(before2);
        System.out.println(acquire);

        boolean b = atomicInteger.compareAndSet(4, 50);

        System.out.printf("b " + b);
    }
}
