package com.repository.collectionssorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Paweł", "Anna", null, "Iwona");

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null) return -1;
                if (o2 == null) return 1;

                return o1.compareTo(o2);
            }
        });

        System.out.println(names);

        names.sort(Comparator.nullsFirst(String::compareTo));

        System.out.println(names);
    }
}
