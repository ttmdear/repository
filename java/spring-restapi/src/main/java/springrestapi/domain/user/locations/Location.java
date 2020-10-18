package springrestapi.domain.user.locations;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import springrestapi.domain.user.BaseEntity;

@Entity()
@Table(name = "LOC_LOCATION")
public class Location extends BaseEntity {

    private final static long serialVersionUID = -1840828358803186869L;

    @OneToOne
    private Address address;

    private Cordinate cordinate;

    public Location() {
        super();
    }

    public Address getAddress() {
        return address;
    }

    public Cordinate getCordinate() {
        return cordinate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCordinate(Cordinate cordinate) {
        this.cordinate = cordinate;
    }
}
