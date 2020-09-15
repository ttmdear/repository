package repo.spring.tests.services.impl;

import repo.spring.tests.services.CounterService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplJunit5IT {

    @Autowired
    CounterService counterService;

    @Test
    public void findById() {

    }

    @Before
    public void setUp() {

    }
}