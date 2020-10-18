package springrestapi.api.v1.dto;

import springrestapi.domain.user.core.Gender;

public class UserDto {
    private String id;
    private String firstName;
    private String username;
    private Gender gender;
    private String lastName;

    public UserDto() {

    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
