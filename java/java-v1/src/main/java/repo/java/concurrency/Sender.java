package repo.java.concurrency;

public class Sender implements Runnable {
    private final Queue queue;

    public Sender(Queue queue) {
        this.queue = queue;
    }

    private static void print(String message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }

    @Override
    public synchronized void run() {
        print("run");

        synchronized (queue) {
            print("int synchronized");

            while (true) {
                print("loop");

                if (!queue.getMessages().isEmpty()) {
                    for (String message : queue.getMessages()) {
                        print("send message " + message);
                    }

                    queue.getMessages().clear();
                }

                try {
                    print("sleep");
                    Thread.sleep(5000);

                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
