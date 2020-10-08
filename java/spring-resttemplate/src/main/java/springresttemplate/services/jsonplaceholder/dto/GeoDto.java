package springresttemplate.services.jsonplaceholder.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GeoDto implements Serializable {

    private final static long serialVersionUID = -7919308727887378246L;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private String lat;
    private String lng;

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}
