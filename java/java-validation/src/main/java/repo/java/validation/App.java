package repo.java.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import repo.java.validation.domain.User;

public class App {
    public static void main(String[] args) {
        User user = new User();

        Validator validator = Validation.byDefaultProvider()
            .configure()
            .buildValidatorFactory()
            .getValidator();

        Set<ConstraintViolation<User>> result = validator.validate(user);

        result.forEach(consumer -> {
            System.out.println(consumer.getPropertyPath().toString() + "  " + consumer.getMessage());
        });
    }
}
