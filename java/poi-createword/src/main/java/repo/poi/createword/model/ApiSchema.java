package repo.poi.createword.model;

import java.util.Map;

public class ApiSchema {
    private Map<String, Map<String, Operation>> paths;
    private Components components;

    public ApiSchema() {

    }

    public Map<String, Map<String, Operation>> getPaths() {
        return paths;
    }

    public void setPaths(Map<String, Map<String, Operation>> paths) {
        this.paths = paths;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }
}
