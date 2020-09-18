package repo.java.concurrency;

import java.util.Arrays;

import repo.java.concurrency.syncmethod.Watch;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void run() {
        // runWaitNotifyNotifyAll();
        runBlockObject();
    }

    private void runBlockObject() {
        Watch watch = new Watch(10);

        new Thread(() -> {
            System.out.println("Wątek A init");
            synchronized (watch) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Wątek A end");
        }).start();

        new Thread(() -> {
            System.out.println("Wątek B " + watch.getTime());
        }).start();
    }

    private void runWaitNotifyNotifyAll() {
        Queue queue = new Queue();

        Sender senderA = new Sender(queue);
        Sender senderB = new Sender(queue);

        new Thread(senderA, "Sender A").start();
        new Thread(senderB, "Sender B").start();

        while (true) {
            queue.addMessage("Hello");

            sleep(5000);

            queue.addMessage(Arrays.asList("Hi John", "Hi Billy", "Hi Foo"));

            sleep(5000);
        }
    }
}
