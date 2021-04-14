package repo.java11.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.SortedMap;

public class App {
    public static void main(String[] args) {
        testIteratorRemove();
        testRemoveAll();
        testRemoveIf();
        testListIterator();
        testPriorityQueue();
    }

    private static void testPriorityQueue() {
        System.out.println("testPriorityQueue");
        PriorityQueue<Integer> list = new PriorityQueue<>();

        list.add(10);
        list.add(20);
        list.add(30);

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

    private static void testRemoveIf() {
        System.out.println("testRemoveIf");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.removeIf(v -> v == 4);

        System.out.println(list);
    }

    private static void testRemoveAll() {
        System.out.println("testRemoveAll");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.removeAll(Arrays.asList(4, 5));

        System.out.println(list);
    }

    private static void testIteratorRemove() {
        System.out.println("testRemovingWith");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        System.out.println(list);
    }
}
