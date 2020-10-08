package springresttemplate.services.jsonplaceholder.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AddressDto implements Serializable {

    private final static long serialVersionUID = -3456220023350258369L;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private String city;
    private GeoDto geoDTO;
    private String street;
    private String suite;
    private String zipcode;

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public String getCity() {
        return city;
    }

    public GeoDto getGeoDTO() {
        return geoDTO;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGeoDTO(GeoDto geoDTO) {
        this.geoDTO = geoDTO;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
