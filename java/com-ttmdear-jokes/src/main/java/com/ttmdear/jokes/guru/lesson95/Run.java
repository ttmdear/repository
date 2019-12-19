package com.ttmdear.jokes.guru.lesson95;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:lesson95.properties")
public class Run implements CommandLineRunner {
    private Environment environment;

    public Run(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-- Lesson 95 --");
        System.out.println(environment.getProperty("lesson95.system-cmd"));
        System.out.println(environment.getProperty("zsh"));
    }
}
