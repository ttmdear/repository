package com.ttmdear.repository.keyfinal.domain;

import java.util.Random;

public class User {
    // private volatile int counter = 0;
    private int counter = 0;

    Random generator = new Random();

    public User() {

    }

    public void count() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
