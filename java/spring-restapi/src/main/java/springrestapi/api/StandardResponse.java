package springrestapi.api;

import java.util.UUID;

public class StandardResponse<D> {
    private String id;
    private D data;

    public StandardResponse() {

    }

    public StandardResponse(D data) {
        id = UUID.randomUUID().toString();

        this.data = data;
    }

    public D getData() {
        return data;
    }

    public String getId() {
        return id;
    }
}
