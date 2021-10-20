/**
 * Przykład implementcji listy w której elementy umieszczane z punktem
 * czasowym. Punkt czasowy jest wykorzystywany przy synchronizacji list.
 */

import org.junit.Test

import java.time.Instant
import java.util.function.Predicate
import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface Identifiable {
    String getId();
}

public class Synchronous<T extends Identifiable> implements Iterable<T> {

    private List<Element<T>> elements = new Vector<>();

    public void add(T signal) {
        boolean found = elements.stream().anyMatch(s -> s.getValue().getId().equals(signal.getId()));

        if (found) return;

        elements.add(new Element<>(signal));
    }

    @SuppressWarnings("unused")
    public void clear() {
        elements.clear();
    }

    public List<T> getAfter(Instant after) {
        return elements.stream()
            .filter(element -> element.getAddedAt().isAfter(after))
            .map(Element::getValue)
            .collect(Collectors.toList());
    }

    public List<T> getAll() {
        return elements.stream().map(Element::getValue).collect(Collectors.toList());
    }

    public Element<T> getElementLast() {
        if (elements.isEmpty()) {
            return null;
        }

        return elements.get(elements.size() - 1);
    }

    public List<Element<T>> getElementsAddedAfter(Instant after) {
        return elements.stream()
            .filter(element -> {
                if (after != null) {
                    return element.getAddedAt().isAfter(after);
                } else {
                    return true;
                }
            })
            .collect(Collectors.toList());
    }

    public T getLast() {
        if (elements.isEmpty()) {
            return null;
        }

        return elements.get(elements.size() - 1).getValue();
    }

    @SuppressWarnings("unused")
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public Iterator<T> iterator() {
        return elements.stream().map(Element::getValue).iterator();
    }

    public MergeInfo<T> mergeWith(Synchronous<T> mergeWith, Instant addedAfter) {
        return mergeWith(mergeWith, addedAfter, null);
    }

    public MergeInfo<T> mergeWith(Synchronous<T> mergeWith, Instant addedAfter, boolean accept) {
        return mergeWith(mergeWith, addedAfter, p -> accept);
    }

    public MergeInfo<T> mergeWith(Synchronous<T> mergeWith, Instant addedAfter, Predicate<T> accept) {
        Instant latestTime = null;

        MergeInfo<T> mergeInfo = new MergeInfo<>(addedAfter);

        for (Element<T> element : mergeWith.getElementsAddedAfter(addedAfter)) {
            if (latestTime == null) {
                latestTime = element.getAddedAt();
            } else if (latestTime.isBefore(element.getAddedAt())) {
                latestTime = element.getAddedAt();
            }

            if (accept != null && !accept.test(element.getValue())) {
                continue;
            }

            add(element.getValue());

            mergeInfo.getAdded().add(element.getValue());
        }

        mergeInfo.setLatestTime(latestTime);

        return mergeInfo;
    }

    @SuppressWarnings("unused")
    public int size() {
        return elements.size();
    }

    public static class Element<T> {

        @Getter
        private final T value;

        @Getter
        private final Instant addedAt;

        private Element(T value) {
            this.value = value;
            addedAt = Instant.now();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class MergeInfo<T> {

        @Getter
        private final List<T> added = new Vector<>();

        @Getter
        @Setter
        private Instant latestTime;

        public boolean isMerge() {
            return latestTime != null;
        }
    }
}

class SynchronousTest extends GroovyTestCase {

    @Test
    void "test add"() {
        Synchronous<User> list = new Synchronous<>()

        list.add(new User())
        list.add(new User())

        assertEquals(2, list.size())
    }

    @Test
    void "test merge"() {
        Synchronous<User> usersA = new Synchronous<>()
        Synchronous<User> usersB = new Synchronous<>()

        usersA.add(new User())
        usersB.add(new User())

        Instant moment = Instant.now()
        sleep(100)

        usersA.add(new User())
        usersA.add(new User())
        usersB.add(new User())
        usersB.add(new User())

        sleep(100)

        Instant momentLast = Instant.now()

        def mergeInfo = usersA.mergeWith(usersB, moment, new Predicate<User>() {
            @Override
            boolean test(User user) {
                return true
            }
        })

        assertEquals(5, usersA.size())
        assertEquals(3, usersB.size())
        assertEquals(2, mergeInfo.getAdded().size())
        assertTrue("Message info has incorrect latest time.", mergeInfo.getLatestTime().isBefore(momentLast))
    }

    @Test
    void "test merge twice"() {
        Synchronous<User> usersA = new Synchronous<>()
        Synchronous<User> usersB = new Synchronous<>()

        usersA.add(new User())
        sleep(10)

        usersA.add(new User())
        sleep(10)

        usersB.add(new User())
        sleep(10)

        usersB.add(new User())

        def mergeA = usersA.mergeWith(usersB, null, true)

        assertEquals(4, usersA.size())
        assertEquals(2, mergeA.getAdded().size())

        usersB.add(new User())
        usersB.add(new User())

        def mergeB = usersA.mergeWith(usersB, mergeA.getLatestTime(), true)

        assertEquals(6, usersA.size())
        assertEquals(2, mergeB.getAdded().size())
    }

    @Test
    void "test add elements with same ID"() {
        Synchronous<User> usersA = new Synchronous<>()

        User userA = new User()

        usersA.add(userA)
        usersA.add(new User())
        usersA.add(new User())
        usersA.add(new User())
        usersA.add(new User())
        usersA.add(userA)

        assertEquals(5, usersA.size())
    }

    private static class User implements Identifiable {
        private String id = UUID.randomUUID().toString()

        @Override
        String getId() {
            return id
        }
    }
}
