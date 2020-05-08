package com.ttmdear.repository.random;

import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 */
public class App {
    public static void main( String[] args ) {
        new App().run();
    }

    public void run() {

        testMatch(1, 100);
        testRandom(1, 100);
        testThreadLocalRandom(1, 100);
        testSplittableRandom(1, 100);
        testSecureRandom(1, 100);
    }

    private void testMatch(int min, int max) {
        int randomValue = (int) ((Math.random() * (max - min)) + min);

        System.out.println("testMatch:" + randomValue);
    }

    private void testRandom(int min, int max) {
        Random random = new Random();

        int randomValue = random.nextInt(max - min) + min;

        System.out.println("testMatch:" + randomValue);

        // Strumień
        random.ints(10, min, max).forEach(v -> System.out.println(v));
    }

    private void testThreadLocalRandom(int min, int max) {
        int randomValue = ThreadLocalRandom.current().nextInt(min, max);

        System.out.println("randomValue: " + randomValue);
    }

    private void testSplittableRandom(int min, int max) {
        SplittableRandom splittableRandom = new SplittableRandom();

        int randomValue = splittableRandom.nextInt(min, max);

        System.out.println("randomValue: " + randomValue);
    }

    private void testSecureRandom(int min, int max) {
        SecureRandom secureRandom = new SecureRandom();

        int randomValue = secureRandom.nextInt(max - min) + min;

        System.out.println("randomValue: " + randomValue);
    }

}
