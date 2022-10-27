package repo.java.lambda;

@FunctionalInterface
public interface SumProvider {
    SumProvider DEFAULT = (a, b) -> a + b;

    Integer sum(Integer a, Integer b);
}
