package repo.java.basis.atomicvariables;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesJMHRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 4)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 2)
    public static void testLongAdderCounter() throws ExecutionException, InterruptedException {
        Counter counter = new LongAdderCounter();

        CompletableFuture.allOf(
            runCounter(counter),
            runCounter(counter)
        ).get();
    }

    public static CompletableFuture<Void> runCounter(Counter counter) {
        return CompletableFuture.runAsync(() -> {
            System.out.printf(Thread.currentThread().getName() + "\n");
            for (int i = 0; i < 100000000; i++) {
                counter.increase();
            }
        });
    }
}