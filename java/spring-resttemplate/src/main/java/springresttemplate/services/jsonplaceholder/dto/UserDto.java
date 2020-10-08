package springresttemplate.services.jsonplaceholder.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserDto implements Serializable {

    private final static long serialVersionUID = 1778626168520906544L;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private AddressDto addressDTO;
    private String email;
    private long id;
    private String name;
    private String username;

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public AddressDto getAddressDTO() {
        return addressDTO;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAddressDTO(AddressDto addressDTO) {
        this.addressDTO = addressDTO;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
