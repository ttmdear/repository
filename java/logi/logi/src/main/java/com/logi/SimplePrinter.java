package com.logi;

public class SimplePrinter implements Printer {
    private String prefix;

    public SimplePrinter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String out) {
        System.out.println(prefix + " " + getClass() + " -> " + out);
    }
}
