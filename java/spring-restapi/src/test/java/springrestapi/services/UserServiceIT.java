package springrestapi.services;

import javax.validation.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springrestapi.domain.user.core.Gender;
import springrestapi.domain.user.core.User;

@SpringBootTest
class UserServiceIT {

    @Autowired
    private UserService userService;

    @Test
    void save() {
        User user = new User();

        user.setLastName("Adamus");
        user.setGender(Gender.MEN);
        user.setEmail("john.adamus@gmail.com");
        user.setPhone("098-345-456");
        user.setUsername("john.adamus");
        user.setPassword("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08");

        try {
            userService.save(user);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            // ((ConstraintViolationException) e.getRootCause()).getConstraintViolations().forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
        }
    }

    @BeforeEach
    void setUp() {

    }
}