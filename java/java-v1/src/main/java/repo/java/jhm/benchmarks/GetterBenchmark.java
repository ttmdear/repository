package repo.java.jhm.benchmarks;

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
public class GetterBenchmark extends BaseBenchmark {
    private List<Integer> numbers;
    private Integer[] numbersArray;

    @Param({"10000000"})
    private int size;

    @Setup(Level.Invocation)
    public void setUp() {
        numbers = new ArrayList<>(size);
        numbersArray = new Integer[size];

        for (int i = 0; i < size; i++) {
            numbers.add(i);
            numbersArray[i] = i;
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode({Mode.Throughput})
    public int withWrittenSize() {
        int a = 0;
        int b = 0;
        int size = numbers.size();
        int number;

        for (int i = 0; i < size; i++) {
            number = numbers.get(i);
            a += number;
            b = b - number + a;
        }

        return a + b;
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode({Mode.Throughput})
    public int withCallSizeEachTime() {
        int a = 0;
        int b = 0;
        int number;

        for (int i = 0; i < numbers.size(); i++) {
            number = numbers.get(i);
            a += number;
            b = b - number + a;
        }

        return a + b;
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode({Mode.Throughput})
    public int withArray() {
        int a = 0;
        int b = 0;
        int number;

        for (int i = 0; i < numbersArray.length; i++) {
            number = numbersArray[i];
            a += number;
            b = b - number + a;
        }

        return a + b;
    }
}
