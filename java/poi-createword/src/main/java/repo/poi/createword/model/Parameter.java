package repo.poi.createword.model;

public class Parameter {
    private String name;
    private String in;
    private String description;
    private boolean required;
    private Schema schema;

    public Parameter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSetDescription() {
        return description != null && !description.isEmpty();
    }

    public boolean isSetSchema() {
        return schema != null;
    }
}
