package repo.java.references;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.text.NumberFormat;

public class SoftReferenceMain {

    public static void main(String[] args) {
        new SoftReferenceMain().run();
    }

    public void run() {
        while(true) {
            sleep(1000);
        }
//        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
//
//        // Counter localCounter = new Counter();
//        // SoftReference<Counter> objectRef = new SoftReference<>(localCounter, referenceQueue);
//
//        SoftReference<Data> objectRef = new SoftReference<>(new Data(), referenceQueue);
//
//        // SoftReference<Counter> objectRef = new SoftReference<>(createCounter(), referenceQueue);
//
//        new Thread(() -> {
//            Data data = objectRef.get();
//            for (int i = 0; i < 10; i++) {
//                data.increase();
//                System.out.println("task " + data.getValue());
//
//                sleep(1000);
//            }
//        }).start();
//
//        while (true) {
//            sleep(1000);
//
//            if (objectRef.get() != null) {
//                System.out.println("object allocated");
//            } else {
//                System.out.println("object cleaned");
//            }
//
//            printReport();
//        }
    }

    private void printReport() {
        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("free memory: " + format.format(freeMemory / 1024) + "\n");
        sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "\n");
        sb.append("max memory: " + format.format(maxMemory / 1024) + "\n");
        sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "\n");

        System.out.println(sb.toString());
    }

    public static Data createCounter() {
        return new Data();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Data {
        private int i;

        void increase() {
            i++;
        }

        int getValue() {
            return i;
        }
    }
}
