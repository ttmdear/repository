package com.ttmdear.repository.tests;

import com.ttmdear.repository.tests.repositories.EmailRepository;
import com.ttmdear.repository.tests.services.CounterService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @AutoConfigureDataJpa
@SpringBootTest
public class TestsApplicationTest {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    CounterService counterService;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void checkTest() {
        System.out.println(counterService);
        System.out.println(emailRepository);
    }
}