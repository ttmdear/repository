package com.ttmdear.repository.hibernate.info.domain;

import com.ttmdear.repository.hibernate.core.domain.Entity;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "INF_PHONE")
public class Phone extends Entity {

    private String value;

    @Column(name = "OWNER_ID")
    private String ownerId;

    public Phone() {
    }

    public Phone(String value, String ownerId) {
        this.value = value;
        this.ownerId = ownerId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
