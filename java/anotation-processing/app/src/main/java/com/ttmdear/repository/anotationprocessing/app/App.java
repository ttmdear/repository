package com.ttmdear.repository.anotationprocessing.app;

import com.ttmdear.repository.anotationprocessing.app.domain.User;
import com.ttmdear.repository.anotationprocessing.app.domain.UserFactory;

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
