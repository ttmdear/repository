package repo.java.basis.atomicvariables;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AtomicVariablesRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new UnsafeCounter();

        CompletableFuture.allOf(
            runCounter(counter),
            runCounter(counter)
        ).get();

        System.out.printf(String.format("counter %s", counter.getValue()));
//        runCounter(counter);
//        runCounter(counter);
    }

    public static CompletableFuture<Void> runCounter(Counter counter) {
        return CompletableFuture.runAsync(() -> {
            System.out.printf(Thread.currentThread().getName() + "\n");
            for (int i = 0; i < 100000; i++) {
                counter.increase();
            }
        });
    }

//    public static void runCounter(Counter counter) {
//        new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//
//            }
//
//            counter.increase();
//        }).start();
//    }
}
