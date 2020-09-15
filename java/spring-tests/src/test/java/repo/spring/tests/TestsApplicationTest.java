package repo.spring.tests;

import repo.spring.tests.repositories.EmailRepository;
import repo.spring.tests.services.CounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// @RunWith(SpringRunner.class)
// @AutoConfigureDataJpa
@SpringBootTest
public class TestsApplicationTest {
    @Autowired
    CounterService counterService;
    @Autowired
    EmailRepository emailRepository;

    @Test
    public void checkTest() {
        System.out.println(counterService);
        System.out.println(emailRepository);
    }

    @BeforeEach
    public void setUp() throws Exception {
    }
}