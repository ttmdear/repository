package repo.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {
        testSetAndAdd();
//        testIteratorRemove();
//        testRemoveAll();
//        testRemoveIf();
//        testListIterator();
//        testPriorityQueue();
//        testEnumSet();
//        testEnumMap();
//        testIdentityHashMap();
//        testCollections();
//        testSubList();
//        testUnmodifiableViews();
//        testSynchronizedViews();
//        testSecuredView();
//        testBinarySearch();
    }

    private static void testSetAndAdd() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));

        // list.add(4, 10);// IndexOutOfBoundsException
        // list.set(4, 10); // IndexOutOfBoundsException
        // list.add(list.size() + 1, 30); // IndexOutOfBoundsException
        list.add(list.size(), 30);

        System.out.printf(Arrays.toString(list.toArray()));
    }

    private static void testBinarySearch() {
        System.out.println("testBinarySearch");

        List<Integer> list = new ArrayList<>(Arrays.asList(23, 1, 304, 123, 45, 23, 123, 598, 234, 120));

        list.sort(Integer::compareTo);

        System.out.println(format("list: %s", list));
        int i = Collections.binarySearch(list, 45);

        System.out.println(format("i: %s", i));
    }

    private static void testSecuredView() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10));

        List p = Collections.checkedList(list, Integer.class);

        // p.add(new Date());
    }

    private static void testCollections() {
        System.out.println("testCollections");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10));

        List<Integer> sub1 = list.subList(3, 4);

        System.out.println(format("sub: %s", sub1));
    }

    private static void testEnumMap() {
        System.out.println("testEnumMap");

        EnumMap<UserRoleType, Integer> data = new EnumMap<>(UserRoleType.class);

        data.put(UserRoleType.ADMIN, 10);
        data.put(UserRoleType.CLIENT, 20);
        data.put(UserRoleType.MANAGER, 30);

        System.out.println(data);
    }

    private static void testEnumSet() {
        EnumSet<UserRoleType> userRoleTypes = EnumSet.allOf(UserRoleType.class);

        userRoleTypes.add(UserRoleType.ADMIN);
    }

    private static void testIdentityHashMap() {
        System.out.println("testIdentityHashMap");

        IdentityHashMap<User, Integer> identityMap = new IdentityHashMap<>();
        HashMap<User, Integer> hashMap = new HashMap<>();

        User user1 = new User("1fa2fa5c-d998-416b-a9ee-8e45e2d8dfbd");
        User user2 = new User("1fa2fa5c-d998-416b-a9ee-8e45e2d8dfbd");
        User user3 = new User("1fa2fa5c-d998-416b-a9ee-8e45e2d8dfbd");

        identityMap.put(user1, 10);
        identityMap.put(user2, 20);
        identityMap.put(user3, 30);

        hashMap.put(user1, 10);
        hashMap.put(user2, 20);
        hashMap.put(user3, 30);

        System.out.println(format("identityMap: %s", identityMap));
        System.out.println(format("map: %s", hashMap));
    }

    private static void testIteratorRemove() {
        System.out.println("testIteratorRemove");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        System.out.println(list);
    }

    private static void testListIterator() {
        System.out.println("testListIterator");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        ListIterator<Integer> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            Integer v = listIterator.next();

            listIterator.add(10);
        }

        System.out.println(list);
    }

    private static void testPriorityQueue() {
        System.out.println("testPriorityQueue");
        PriorityQueue<Integer> list = new PriorityQueue<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
    }

    private static void testRemoveAll() {
        System.out.println("testRemoveAll");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.removeAll(Arrays.asList(4, 5));

        System.out.println(list);
    }

    private static void testRemoveIf() {
        System.out.println("testRemoveIf");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.removeIf(v -> v == 4);

        System.out.println(list);
    }

    private static void testSubList() {
        System.out.println("testSubList");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> sub1 = list.subList(2, 4);

        // Dodanie do przedziały i do listy bazowe
        sub1.add(10);
        sub1.add(20);

        System.out.println(format("A.list: %s", list));
        System.out.println(format("A.sub1: %s", sub1));

        sub1.removeIf(v -> v == 20);

        System.out.println(format("B.list: %s", list));
        System.out.println(format("B.sub1: %s", sub1));

        // Usunięcie
        sub1.clear();

        System.out.println(format("C.list: %s", list));
        System.out.println(format("C.sub1: %s", sub1));
    }

    private static void testSynchronizedViews() {
        System.out.println("testSynchronized");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10));
        List<Integer> synchronizedList = Collections.synchronizedList(list);
    }

    private static void testUnmodifiableViews() {
        System.out.println("testUnmodifiable");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10));

        List<Integer> unmodifiableList = Collections.unmodifiableList(list);

        // unmodifiableList.add(20);// UnsupportedOperationException
    }

    private static class PrintList implements Runnable {
        private final String name;
        private final List<Integer> list;

        private PrintList(String name, List<Integer> list) {
            this.name = name;
            this.list = list;
        }

        @Override
        public void run() {
            for (Integer v : list) {
                System.out.println(format("%s -> %s", name, v));
            }
        }
    }
}
