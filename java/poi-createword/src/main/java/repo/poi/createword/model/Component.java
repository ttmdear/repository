package repo.poi.createword.model;

import java.util.Map;

public class Component {
    private String type;
    private Map<String, Schema> properties;

    public Component() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Schema> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Schema> properties) {
        this.properties = properties;
    }

    public boolean hasProperties() {
        return properties != null && !properties.isEmpty();
    }
}
