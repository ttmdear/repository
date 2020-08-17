package com.repository.anotationprocessing;

import com.repository.anotationprocessing.domain.User;
import com.repository.anotationprocessing.domain.UserFactory;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        User user = (new UserFactory())
                .setFirstName("Paweł Kowalski")
                .setBirthDate(new Date())
                .create();

        System.out.println("user: " + user);
    }
}
