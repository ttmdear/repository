package repo.performance.tests.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class ListIterateBenchmarks extends BaseBenchmark {
    private List<Integer> numbers;

    @Param({"1000000"})
    private int size;

    @Setup(Level.Invocation)
    public void setUp() {
        numbers = new ArrayList<>(size);

        for(int i=0; i < size; i++) {
            numbers.add(i);
        }
    }

    @Benchmark
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
    public int testLoopFor() {
        int a = 0;
        int b = 0;

        for (Integer number : numbers) {
            a += number;
            b = b - number + a;
        }

        return a + b;
    }
}
