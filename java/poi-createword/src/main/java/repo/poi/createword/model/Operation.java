package repo.poi.createword.model;

import java.util.List;
import java.util.Map;

public class Operation {
    private List<String> tags;
    private String summary;
    private String description;
    private String operationId;
    private List<Parameter> parameters;
    private RequestBody requestBody;
    private Map<String, Response> responses;

    public Operation() {
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSetSummary() {
        return summary != null && !summary.isEmpty();
    }

    public boolean isSetDescription() {
        return description != null && !description.isEmpty();
    }

    public boolean hasParameters() {
        return parameters != null && !parameters.isEmpty();
    }

    public boolean isSetRequestBody() {
        return requestBody != null;
    }

    public Map<String, Response> getResponses() {
        return responses;
    }

    public void setResponses(Map<String, Response> responses) {
        this.responses = responses;
    }

    public boolean hasResponses() {
        return responses != null && !responses.isEmpty();
    }

    public boolean hasTags() {
        return tags != null && !tags.isEmpty();
    }
}
