package repo.java.validation.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import repo.java.validation.validators.constraints.UserConstraint;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Constraint(validatedBy = {UserConstraint.class})
public @interface UserValidator {
    public Class<?>[] groups() default {};

    public String message() default "{validation.user.error}";

    public Class<? extends Payload>[] payload() default {};
}
