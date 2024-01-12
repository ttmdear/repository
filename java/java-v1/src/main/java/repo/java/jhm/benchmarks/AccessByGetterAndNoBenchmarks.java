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

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class AccessByGetterAndNoBenchmarks extends BaseBenchmark {
    private User[] userList;

    @Param({"1000000"})
    private int size;

    @Setup(Level.Invocation)
    public void setUp() {
        userList = new User[size];

        for (int i = 0; i < size; i++) {
            userList[i] = new User(i);
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Measurement(iterations = 2)
    @BenchmarkMode({Mode.Throughput})
    public int withGetByField() {
        int a = 0;
        int b = 0;

        for (int i = 0; i < userList.length; i++) {
            a = userList[i].age;
            b = a - b;
        }

        return a + b;
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Measurement(iterations = 2)
    @BenchmarkMode({Mode.Throughput})
    public int withGetByGetter() {
        int a = 0;
        int b = 0;

        for (int i = 0; i < userList.length; i++) {
            a = userList[i].getAge();
            b = a - b + userList[i].getAge2() - userList[i].getAge3() - userList[i].getAge4();
        }

        return a + b;
    }

    public static class User {
        public int age = 0;
        public int age2 = 0;
        public int age3 = 0;
        public int age4 = 0;

        public User(int age) {
            this.age = age;
            this.age2 = age + 1;
            this.age3 = age + 2;
            this.age4 = age + 3;
        }

        public int getAge() {
            return age;
        }

        public int getAge2() {
            return age2;
        }

        public int getAge3() {
            return age3;
        }

        public int getAge4() {
            return age4;
        }
    }
}
