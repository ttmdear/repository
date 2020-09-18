package repo.java.concurrency.syncmethod;

public class Watch {
    private final int time;

    public Watch(int time) {
        this.time = time;
    }

    public synchronized int getTime() {
        return time;
    }
}
