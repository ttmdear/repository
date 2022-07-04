package repo.poi.createword.model;

import java.util.Map;
import java.util.Set;

public class Response {
    private String description;
    private Map<String, ContentVariant> content;

    public Response() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, ContentVariant> getContent() {
        return content;
    }

    public void setContent(Map<String, ContentVariant> content) {
        this.content = content;
    }

    public ContentVariant getContentVariant() {
        if (content == null || content.isEmpty()) {
            return null;
        }

        return content.get(first(content.keySet()));
    }

    public boolean isSetContentVariant() {
        return getContentVariant() != null;
    }

    private <T> T first(Set<T> set) {
        for (T t : set) {
            return t;
        }

        return null;
    }
}
