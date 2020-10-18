package springrestapi.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springrestapi.api.StandardResponse;

public class BaseController {
    public static final String BASE_URL = "/v1";

    protected <T> ResponseEntity<StandardResponse<T>> prepareResponse(T data) {
        return prepareResponse(data, HttpStatus.OK);
    }

    protected <T> ResponseEntity<StandardResponse<T>> prepareResponse(T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(new StandardResponse<>(data), httpStatus);
    }
}
