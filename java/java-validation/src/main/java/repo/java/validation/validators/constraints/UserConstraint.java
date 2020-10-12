package repo.java.validation.validators.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import repo.java.validation.domain.User;
import repo.java.validation.validators.UserValidator;

public class UserConstraint implements ConstraintValidator<UserValidator, User> {
    @Override
    public void initialize(UserValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
