/**
 * Przyklad kontrolera do obsługi błędów w Springu
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ErrorResponse> handleError(ValidationException e) {
        return createClientErrorResponse(e);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleInternalError(RuntimeException e) {
        return createInternalErrorResponse(e);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
        HttpStatus status, WebRequest request) {

        ResponseEntity<ErrorResponse> communicationResponse = createCommunicationErrorResponse(ex);

        return new ResponseEntity<>(communicationResponse.getBody(), communicationResponse.getHeaders(),
            communicationResponse.getStatusCode());
    }

    private ResponseEntity<ErrorResponse> createCommunicationErrorResponse(Exception e) {
        log.error("Communication error while handling notice generation request", e);
        return createErrorResponse(e, HttpStatus.BAD_REQUEST, ErrorCodes.COMMUNICATION_ERROR);
    }

    private ResponseEntity<ErrorResponse> createInternalErrorResponse(Exception e) {
        log.error("Internal error while handling notice generation request", e);
        return createErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> createClientErrorResponse(Exception e) {
        log.error("Error while handling notice generation request: [{}]", e.getMessage());
        return createErrorResponse(e, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(Exception e, HttpStatus status) {
        return createErrorResponse(e, status, null);
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(Exception e, HttpStatus status, ErrorCodes errorCode) {
        ErrorResponse errorResponse = new ErrorResponse();

        if (errorCode != null) {
            errorResponse.code(errorCode.getCode());
        } else if (e instanceof ErrorCodeAware) {
            errorResponse.code(((ErrorCodeAware) e).getErrorCode());
        } else {
            errorResponse.code(ErrorCodes.INTERNAL_GENERATION_ERROR.getCode());
        }

        errorResponse.message(e.getMessage());

        return new ResponseEntity<>(errorResponse, status);
    }
}
