package repo.poi.createword.model;

public class ContentVariant {
    private Schema schema;

    public ContentVariant() {
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public boolean hasSchema() {
        return schema != null;
    }
}
