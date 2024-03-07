package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Util {

    public static void sleep(long time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void log(String message, Object... vars) {
        List<Object> vars2 = new ArrayList<>();
        vars2.add(Thread.currentThread().getName());
        vars2.addAll(List.of(vars));

        System.out.printf("[%s] " + message + "%n", vars2.toArray());
    }

    public static Consumer<String> log() {
        return Util::log;
    }
}
