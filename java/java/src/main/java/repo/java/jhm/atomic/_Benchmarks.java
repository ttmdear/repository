package repo.java.jhm.atomic;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class _Benchmarks {

    // @Benchmark
    @Fork(1)
    @Warmup(iterations = 3, time = 10)
    @Measurement(iterations = 1, time = 10)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static void testLongAdderCounter() throws ExecutionException, InterruptedException {
        Counter counter = new LongAdderCounter();
        counter.increase();

        CompletableFuture.allOf(
            runCounter(counter),
            runCounter(counter)
        ).get();
    }

    // @Benchmark
    @Fork(1)
    @Warmup(iterations = 3, time = 10)
    @Measurement(iterations = 1, time = 10)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static void testSynchronizedCounter() throws ExecutionException, InterruptedException {
        Counter counter = new SynchronizedCounter();

        CompletableFuture.allOf(
            runCounter(counter),
            runCounter(counter)
        ).get();
    }

    // @Benchmark
    @Fork(1)
    @Warmup(iterations = 3, time = 10)
    @Measurement(iterations = 1, time = 10)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public static void testAtomicIntegerCounter() throws ExecutionException, InterruptedException {
        Counter counter = new AtomicIntegerCounter();

        CompletableFuture.allOf(
            runCounter(counter),
            runCounter(counter)
        ).get();
    }

    public static CompletableFuture<Void> runCounter(Counter counter) {
        return CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 100000000; i++) {
                counter.increase();
            }
        });
    }
}
