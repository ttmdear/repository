package com.ttmdear.repository.tests.services;

import org.springframework.stereotype.Service;

@Service
public class CounterService {
    public int sum(int a, int b) {
        return a + b;
    }
}
