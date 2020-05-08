package com.ttmdear.repository.springtransactions.core.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class User extends BaseEntity {
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "userRoleId.user")
    private List<UserRole> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserPhone> phones = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<UserGroup> groups = new ArrayList<>();

    public User() { }

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

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<UserPhone> getPhones() {
        return phones;
    }

    public void setPhones(List<UserPhone> phones) {
        this.phones = phones;
    }
}
