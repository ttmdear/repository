package repo.java.lambda;

@FunctionalInterface
public interface EventListener {
    void on(String event);
}
