package springrestapi.domain.user.locations;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import springrestapi.domain.user.BaseEntity;

@Entity()
@Table(name = "LOC_ADDRESS")
public class Address extends BaseEntity {

    private final static long serialVersionUID = -1840828358803186869L;

    private String street;
    private String city;
    private String postcode;

    @Embedded
    private Cordinate cordinate;

    public Address() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCity() {
        return city;
    }

    public Cordinate getCordinate() {
        return cordinate;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCordinate(Cordinate cordinate) {
        this.cordinate = cordinate;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
