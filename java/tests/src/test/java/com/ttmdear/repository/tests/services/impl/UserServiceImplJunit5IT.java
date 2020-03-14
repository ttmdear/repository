package com.ttmdear.repository.tests.services.impl;

import com.ttmdear.repository.tests.services.CounterService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplJunit5IT {

    @Autowired
    CounterService counterService;

    @Before
    public void setUp() {

    }

    @Test
    public void findById() {

    }
}