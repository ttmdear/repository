package repo.java.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferenceMain {

    public static void main(String[] args) {
        new WeakReferenceMain().run();
    }

    public void run() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Counter> objectRef = new WeakReference<>(new Counter(), referenceQueue);
        // WeakReference<Counter> objectRef = new WeakReference<>(createCounter(), referenceQueue);

        new Thread(() -> {
            Counter counter = objectRef.get();
            for (int i = 0; i < 10; i++) {
                counter.increase();
                System.out.println("task " + counter.getValue());

                sleep(1000);
            }
        }).start();

        while (true) {
            Reference<?> poll = referenceQueue.poll();

            if (poll != null) {
                System.out.println("object cleaned");
                break;
            } else {
                System.out.println("object allocated");
                sleep(1000);
                System.gc();
            }
        }

        while(true) {
            sleep(1000);
            System.gc();

            if (objectRef.get() != null) {
                System.out.println("object allocated");
            } else {
                System.out.println("object cleaned");
            }
        }
    }

    public static Counter createCounter() {
        return new Counter();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Counter {
        private int i;

        void increase() {
            i++;
        }

        int getValue() {
            return i;
        }
    }
}
