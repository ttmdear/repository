package com.ttmdear.jokes.guru.lesson94;

import com.ttmdear.jokes.guru.lesson94.services.FakeDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunCommand implements CommandLineRunner {
    private FakeDataSource fakeDataSource;

    public RunCommand(FakeDataSource fakeDataSource) {
        this.fakeDataSource = fakeDataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-- Lesson 94 --");
        System.out.println(fakeDataSource.toString());
    }
}
