package repo.java.references;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ObserversMain {
    public static void main(String[] args) {
        new ObserversMain().run();
    }

    public void run() {

    }

    public class EventBusSimple {
        private List<Listener> listeners = new ArrayList<>();

        public void addListener(Listener listener) {
            listeners.add(listener);
            // ...
        }

        public void removeListener(Listener listener) {
            listeners.removeIf(listenerRef -> listenerRef == listener);
            // ...
        }

        // emit, handle ...
    }

    public class EventBus {
        private List<WeakReference<Listener>> listeners = new ArrayList<>();

        public void addListener(Listener listener) {
            listeners.add(new WeakReference<>(listener));
            cleanupListeners();
        }

        public void removeListener(Listener listener) {
            listeners.removeIf(listenerWeakReference ->
                listenerWeakReference.get() != null && listenerWeakReference.get() == listener);

            cleanupListeners();
        }

        private void cleanupListeners() {
            listeners.removeIf(listenerWeakReference -> listenerWeakReference.get() == null);
        }
    }

    public interface Listener {
        void onNotify();
    }
}
