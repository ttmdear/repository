package repo.java.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PhantomReferenceMain {

    public static void main(String[] args) {
        new PhantomReferenceMain().caseWithFinalize();
        new PhantomReferenceMain().caseWithCheck();
    }

    public void caseWithCheck() {
        User user = new User(UUID.randomUUID().toString());

        ReferenceQueue<User> referenceQueue = new ReferenceQueue<>();
        PhantomReference<User> userRef = new PhantomReference<>(user, referenceQueue);

        new Thread(() -> {
            Reference<? extends User> poll;

            while((poll = referenceQueue.poll()) == null) {
                sleep(1000);

                System.out.println("not cleared");
            }

            System.out.println("cleared");
        }).start();

        user = null;
        System.gc();

        // ... rest of process
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void caseWithFinalize() {
        ReferenceQueue<User> referenceQueue = new ReferenceQueue<>();

        List<UserFinalizer> userFinalizers = new ArrayList<>();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            User user = new User(UUID.randomUUID().toString());
            users.add(user);
            userFinalizers.add(new UserFinalizer(user, referenceQueue));
        }

        // Clean strong references
        users = null;
        System.gc();

        for (PhantomReference<User> reference : userFinalizers) {
            // Java < 16 -> reference.isEnqueued();
            System.out.println(reference.refersTo(null));
        }

        Reference<?> referenceFromQueue;

        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            // Object cleared
            ((UserFinalizer) referenceFromQueue).finalizeResources();
            referenceFromQueue.clear();
        }

    }

    public static class User {
        String id;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }

        public User(String id) {
            this.id = id;
        }
    }

    public static class UserFinalizer extends PhantomReference<User> {

        public UserFinalizer(User user, ReferenceQueue<? super User> q) {
            super(user, q);
        }

        public void finalizeResources() {
            // free resources
            System.out.println("clearing ...");
        }
    }
}
