package com.ttmdear.recipeapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne
    @JoinTable(
        name = "userEmail",
        joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "emailId", referencedColumnName = "id")}
    )
    private Email email;

    @OneToMany
    @JoinTable(
        name = "USER_PHONE",
        joinColumns = {@JoinColumn(name = "phoneId")},
        inverseJoinColumns = {@JoinColumn(name = "userId")}
    )
    private Set<Phone> phones = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
