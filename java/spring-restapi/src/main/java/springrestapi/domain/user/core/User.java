package springrestapi.domain.user.core;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import springrestapi.domain.user.BaseEntity;
import springrestapi.domain.user.locations.Address;
import springrestapi.domain.user.resources.Picture;

@Entity
@Table(name = "CORE_USER")
public class User extends BaseEntity implements Serializable {
    private final static long serialVersionUID = 859987748903105215L;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private String username;

    private String password;
    private String salt;

    @NotNull
    private Gender gender;

    @OneToOne
    private Address address;

    private String email;

    private String phone;

    @OneToOne
    private Picture picture;

    public User() {
        super();
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getSalt() {
        return salt;
    }

    public String getUsername() {
        return username;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
