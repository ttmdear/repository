package repo.microbenchmarking;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Benchmark)
public class ForAndStreamBenchmark {
    private Integer[] numbers;
    private List<Integer> numbersList;
    private static final Random random = new Random();

    static {
    }

    @Param({"1000000"})
    // @Param({"10", "100", "1000", "10000", "100000"})
    private int size;

    private int loopIndexSum = 0;
    private int loopIteratorSum = 0;
    private int loopFuncSum = 0;
    private int loopStreamSum = 0;
    private int loopListIndex = 0;
    private int loopListToArray = 0;
    private int loopParallelStream = 0;

    public ForAndStreamBenchmark() {
    }

    @Setup(Level.Invocation)
    public void setUp() {
        numbers = new Integer[size];

        for(int i = 0; i < numbers.length; i++) {
            // numbers[i] = random.nextInt(10);
            numbers[i] = i;
        }

        numbersList = Arrays.asList(numbers);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.SingleShotTime)
    // @BenchmarkMode(Mode.AverageTime)
    // @Fork(value = 1, warmups = 4)
    // @Warmup(iterations = 3, time = 1)
    // @Measurement(iterations = 5, time = 2)
    public void runLoopIndex() {
        for(int i = 0; i < numbers.length; i++) {
            loopIndexSum += numbers[i];
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.SingleShotTime)
    public void runLoopListIndex() {
        for(int i = 0; i < numbers.length; i++) {
            loopListIndex += numbersList.get(i);
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.SingleShotTime)
    public void runLoopListToArray() {
        Integer[] l = numbersList.toArray(new Integer[0]);

        for(int i = 0; i < numbers.length; i++) {
            loopListToArray += l[i];
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.SingleShotTime)
    public void runLoopIterator() {
        for (Integer number : numbersList) {
            loopIteratorSum += number;
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.SingleShotTime)
    public void runLoopFunc() {
        numbersList.forEach(number -> {
            loopFuncSum += number;
        });
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.SingleShotTime)
    public void runLoopStream() {
        numbersList.stream().forEach(number -> {
            loopStreamSum += number;
        });
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.SingleShotTime)
    public void runLoopParallelStream() {
        numbersList.stream().parallel().forEach(number -> {
            loopParallelStream += number;
        });
    }
}

