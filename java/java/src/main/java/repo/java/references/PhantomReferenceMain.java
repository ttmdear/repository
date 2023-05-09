package repo.java.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class PhantomReferenceMain {
    public static void main(String[] args) {
        new PhantomReferenceMain().run();
    }

    public void run() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        List<LargeObjectFinalizer> references = new ArrayList<>();
        List<Object> largeObjects = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            Object largeObject = new Object();
            largeObjects.add(largeObject);
            references.add(new LargeObjectFinalizer(largeObject, referenceQueue));
        }

        largeObjects = null;
        System.gc();

        Reference<?> referenceFromQueue;
        for (PhantomReference<Object> reference : references) {
            // System.out.println(reference.isEnqueued());
            System.out.println(reference.refersTo(null));
        }

        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            ((LargeObjectFinalizer) referenceFromQueue).finalizeResources();
            referenceFromQueue.clear();
        }
    }

    public class LargeObjectFinalizer extends PhantomReference<Object> {

        public LargeObjectFinalizer(
            Object referent, ReferenceQueue<? super Object> q) {
            super(referent, q);
        }

        public void finalizeResources() {
            // free resources
            System.out.println("clearing ...");
        }
    }
}
