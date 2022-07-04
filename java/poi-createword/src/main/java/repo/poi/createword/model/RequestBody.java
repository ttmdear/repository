package repo.poi.createword.model;

import java.util.Map;
import java.util.Set;

public class RequestBody {
    private Map<String, ContentVariant> content;

    public RequestBody() {
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

    public Schema getContentSchema() {
        ContentVariant contentVariant = getContentVariant();

        if (contentVariant == null) {
            return null;
        }

        return contentVariant.getSchema();
    }

    public boolean isSetContentSchema() {
        return getContentSchema() != null;
    }

    private <T> T first(Set<T> set) {
        for (T t : set) {
            return t;
        }

        return null;
    }
}
