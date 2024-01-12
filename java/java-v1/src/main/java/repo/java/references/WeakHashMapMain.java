package repo.java.references;

import org.apache.commons.math3.random.AbstractRandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.WeakHashMap;

public class WeakHashMapMain {

    public static void main(String[] args) {
        new WeakHashMapMain().run();
    }

    public void run() {
        UserRepo userRepo = new UserRepo();
        List<UserKey> keys = new ArrayList<>();

        new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
                UserKey userKey = new UserKey(UUID.randomUUID().toString());

                if (i % 2 == 0) {
                    keys.add(userKey);
                }

                userRepo.getUser(userKey);

                if (i == 10) {
                    System.out.println("end of logic");
                    return;
                }

                sleep(500);
            }
        }).start();

        while (true) {
            System.out.println("size " + userRepo.cacheSize());
            System.gc();
            sleep(1000);
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class UserRepoKey {

        private final Map<UserKey, User> userCache = new WeakHashMap<>();

        public User getUser(UserKey key) {
            return userCache.computeIfAbsent(key, userKey -> {
                return new User(key.value);
            });
        }

        public int cacheSize() {
            return userCache.size();
        }
    }

    public static class UserRepo {
        private final Map<UserKey, User> userCache = new WeakHashMap<>();

        public User getUser(UserKey key) {
            return userCache.computeIfAbsent(key, userKey -> {
                return new User(key.value);
            });
        }

        public int cacheSize() {
            return userCache.size();
        }
    }

    public static class UserKey {
        private String value;

        public UserKey(String value) {
            this.value = value;
        }
    }

    public static class User {
        private String id;

        public User(String id) {
            this.id = id;
        }
    }
}
