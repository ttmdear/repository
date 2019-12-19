package com.ttmdear.jokes.guru.lesson85;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Scope("prototype")
public class CounterService {
    private String id;

    public CounterService() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }
}
