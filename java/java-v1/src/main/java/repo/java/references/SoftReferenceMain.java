package repo.java.references;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

public class SoftReferenceMain {

    public static void main(String[] args) {
        new SoftReferenceMain().run();
    }

    public void run() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Cache cache = new Cache();

        new Thread(() -> {
            while (true) {
                cache.put(new User());
                sleep(1);
            }
        }).start();

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

    public static class Cache {
        private List<SoftReference<User>> users = new ArrayList<>();
        private ReferenceQueue<User> referenceQueue = new ReferenceQueue<>();

        public void put(User user) {
            users.add(new SoftReference<>(user, referenceQueue));
            clean();
        }

        private void clean() {
            Reference<? extends User> poll;

            while((poll = referenceQueue.poll()) != null) {
                System.out.println("%s cleaned\n".formatted(poll.get().id));
            }
        }
    }

    public static class User {
        String id;
        String body;

        public User() {
            id = UUID.randomUUID().toString();
//            System.out.println("put %s".formatted(id));

            StringBuilder bodyBuilder = new StringBuilder();

            for (int i = 0; i < 10000000; i++) {
                bodyBuilder.append(UUID.randomUUID());
            }

            body = bodyBuilder.toString();
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
