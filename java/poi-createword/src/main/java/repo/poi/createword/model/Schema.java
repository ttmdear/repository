package repo.poi.createword.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Schema {
    private String type;
    private String format;

    @JsonProperty("enum")
    private List<String> enum_;

    @JsonProperty("$ref")
    private String ref;

    public Schema() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public boolean hasRef() {
        return ref != null && !ref.isEmpty();
    }

    public boolean hasType() {
        return type != null && !type.isEmpty();
    }

    public String getRefTarget() {
        if (ref == null) {
            return null;
        }

        String[] split = ref.split("/");

        return split[split.length - 1];
    }

    public List<String> getEnum() {
        return enum_;
    }

    public void setEnum(List<String> enum_) {
        this.enum_ = enum_;
    }

    public boolean hasEnum() {
        return enum_ != null && !enum_.isEmpty();
    }
}
