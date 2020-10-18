package springrestapi.domain.user.locations;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Cordinate implements Serializable {

    private final static long serialVersionUID = -1840828358803186869L;

    private double latitude;
    private double longitude;

    public Cordinate() {
    }

    public Cordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cordinate cordinate = (Cordinate) o;
        return Objects.equals(latitude, cordinate.latitude) &&
            Objects.equals(longitude, cordinate.longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
