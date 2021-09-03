package repo.java.memory.dump;

import java.util.UUID;

public class Node {
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}