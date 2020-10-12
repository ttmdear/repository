package repo.java.validation.domain;

import java.util.List;
import java.util.Vector;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import repo.java.validation.validators.UserValidator;

@UserValidator
public class User {

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @Min(value = 1, message = "Wiek powinien mieć minumum {min}")
    @Max(value = 100)
    private int age;

    private List<Contact> contacts = new Vector<>();

    public User() {
    }

    public int getAge() {
        return age;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
