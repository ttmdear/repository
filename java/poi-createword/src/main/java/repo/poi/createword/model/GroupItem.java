package repo.poi.createword.model;

public class GroupItem {
    private String method;
    private String path;
    private Operation operation;

    public GroupItem(String method, String path, Operation operation) {
        this.method = method;
        this.path = path;
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Operation getOperation() {
        return operation;
    }
}
