package springrestapi.api.v1;

import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springrestapi.api.StandardResponse;

@ControllerAdvice
public class ApiControllerAdvice {
    private static Map<String, String> resolveMessages(ConstraintViolationException exception) {
        HashMap<String, String> errors = new HashMap<>();

        exception.getConstraintViolations().forEach(constraintViolation -> {
            errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        });

        return errors;
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<StandardResponse<?>> handleTransactionSystemException(TransactionSystemException exception) {
        if (exception.getRootCause() instanceof ValidationException) {
            return handleValidationException((ValidationException) exception.getRootCause());
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<StandardResponse<?>> handleValidationException(ValidationException exception) {
        if (exception instanceof ConstraintViolationException) {
            return new ResponseEntity<>(
                new StandardResponse<>(resolveMessages((ConstraintViolationException) exception)),
                HttpStatus.BAD_REQUEST);
        } else {
            return null;
        }
    }


}
