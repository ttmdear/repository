package com.ttmdear.repository.jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseEntity {
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
        name = "userEmail",
        joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "emailId", referencedColumnName = "id")}
    )
    private Email email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID_FOO")
    private Set<Phone> phones = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "USER_TAG",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TAG_ID")}
    )
    private Set<Tag> tags = new HashSet<>();

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
