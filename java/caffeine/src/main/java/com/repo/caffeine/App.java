package com.repo.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class App {
    private Cache<Integer, String> userNameCache;

    public static void main(String[] args) throws InterruptedException {
        new App().run();
    }

    public App() {
        userNameCache = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .maximumSize(10)
            .build();
    }

    public void run() throws InterruptedException {
        // Add map

        System.out.println(getUserName(new User(10, "Paweł", "Kowalski")));
        System.out.println(getUserName(new User(11, "Jan", "Iksiński")));
        System.out.println(getUserName(new User(12, "Monika", "Łubik")));

        Thread.sleep(2000);

        System.out.println("-----------------------");

        System.out.println(getUserName(new User(10, "Paweł", "Kowalski")));
        System.out.println(getUserName(new User(11, "Jan", "Iksiński")));
        System.out.println(getUserName(new User(12, "Monika", "Łubik")));

        Thread.sleep(5000);

        System.out.println("-----------------------");

        System.out.println(getUserName(new User(10, "Paweł", "Kowalski")));
        System.out.println(getUserName(new User(11, "Jan", "Iksiński")));
        System.out.println(getUserName(new User(12, "Monika", "Łubik")));
    }

    private String getUserName(final User user) {
        return userNameCache.get(user.getId(), new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                System.out.println("init cache for " + integer);

                return String.format("%s %s", user.getFirstName(), user.getLastName());
            }
        });
    }
}
