package repo.java.array;

import java.util.*;

public class App {
    public static void main(String[] args) {
        construct();
        assign();
        comparing();
        fill();
        parallelPrefix();
        listIterator();
        copyOff();
    }

    private static void copyOff() {
        Integer a[] = new Integer[]{5, 10, 15, 20, 25};
        Integer b[] = Arrays.copyOf(a, a.length);

        b[2] = 20;

        System.out.printf("a -> %s%n", Arrays.toString(a));
        System.out.printf("b -> %s%n", Arrays.toString(b));
    }

    private static void listIterator() {
        Integer a[] = new Integer[]{5, 10, 15, 20, 25};
        ListIterator<Integer> iter = Arrays.asList(a).listIterator();
        while (iter.hasNext()) {
            System.out.printf("i -> %s, v -> %s%n", iter.nextIndex(), iter.next());

            if (iter.hasPrevious()) {

            }
        }
    }

    private static void fill() {
        int a[] = new int[]{5, 10, 15, 20, 25};
        Arrays.fill(a, 20);

        System.out.printf("a -> %s%n", Arrays.toString(a));

        Arrays.parallelPrefix(a, (left, right) -> {
            System.out.printf("left -> %s, right -> %s%n", left, right);
            return right;
        });

        System.out.printf("a -> %s%n", Arrays.toString(a));
    }

    private static void parallelPrefix() {
        int a[] = new int[]{5, 10, 15, 20, 25};

        Arrays.parallelPrefix(a, (left, right) -> left + right);

        System.out.printf("a -> %s%n", Arrays.toString(a));
    }

    private static void comparing() {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {1, 2, 3, 5, 5};

        boolean equals = Arrays.equals(a, b);

        System.out.printf("equals -> %s%n", equals);

        int compare = Arrays.compare(a, b);
        System.out.printf("compare -> %s%n", compare);
    }

    private static void assign() {
        int a[] = {1, 2, 3};
        Integer b[] = new Integer[3];

        int a1[] = a;
        Integer b1[] = new Integer[5];

        a[0] = 10;
        a1[0] = 20;

        System.out.printf("a %s%n", Arrays.toString(a)); // a [20, 2, 3]
        System.out.printf("a1 %s%n", Arrays.toString(a1)); // a1 [20, 2, 3]
    }

    private static void construct() {
        int[] a1 = {1, 2};
        int[] a2 = new int[]{1, 2};
        int[] a3 = new int[2];

        int b1[] = {1, 2};
        int b2[] = new int[]{1, 2};
        int b3[] = new int[2];

        int[] c1[] = {{1}, {2}};
        int c2[][] = {{1}, {2}};

        String[] s = new String[10];
    }
}
