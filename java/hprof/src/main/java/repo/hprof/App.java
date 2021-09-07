package repo.hprof;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        // java -agentlib:hprof=heap=sites <classname>
        // java -agentlib:hprof=cpu=samples <classname>
        // java -agentlib:hprof=cpu=times <classname>
        // -agentlib:hprof=cpu=times,interval=1000
        new LoopInLoopTest().run();
    }
}
