package com.ttmdear.repository.tests.services.impl;

import com.ttmdear.repository.tests.repositories.EmailRepository;
import com.ttmdear.repository.tests.services.CounterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataJpa
public class UserServiceImplJunit4IT {

    @Autowired
    CounterService counterService;

    @Autowired
    EmailRepository emailRepository;

    @Before
    public void setUp() {
        System.out.println("before");
    }

    @Test
    public void findById() {
        System.out.println(counterService);
        System.out.println(emailRepository);
    }
}