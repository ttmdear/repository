package com.ttmdear.repository.springtransactions.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserPhone extends BaseEntity {
    private String value;
    private boolean active;

    @ManyToOne
    private User user;

    public UserPhone() { }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
