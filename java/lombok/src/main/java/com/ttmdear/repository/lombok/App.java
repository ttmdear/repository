package com.ttmdear.repository.lombok;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.ttmdear.repository.lombok.domain.Price;
import com.ttmdear.repository.lombok.domain.User;
import com.ttmdear.repository.lombok.domain.Worker;

import javax.jws.soap.SOAPBinding;
import java.util.Locale;

public class App
{
    public static void main( String[] args ) {

        final User user = new User();

        user.setFirstName("Paweł");
        user.setLastName("Kowalski");

        user.setId("10");

        System.out.println(user);
        System.out.println(user.getFullName());

        // NonNull
        // Worker worker = new Worker();
        // worker.sendTo(null);

        // Value
        Price price = new Price(10, "EUR");

        // Builder
        Worker w = Worker.builder().id("10").name("Kowalski").build();

        // thA();
        // thB();

        // With
        testWith();
    }

    private static void testWith() {
        Price price = new Price(10, "EUR");

        Price price1 = price.withValue(20);

        System.out.println(price);
        System.out.println(price1);
    }

    private static void thB() {
        final User user = new User();

        user.setFirstName("Paweł");
        user.setLastName("Kowalski");

        user.setId("10");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run A");

                user.setLevelOfSure("TOP");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run B");

                System.out.println(user.getLevelOfSure());
            }
        }).start();
    }

    private static void thA() {
        // Threads
        System.out.println("-------------------------------");
        final User userA = new User();
        userA.setId("User A");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run A");
                try {
                    userA.sendToNotification();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run B");
                try {
                    userA.sendToNotification();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run C");
                try {
                    userA.sendToEmail();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
