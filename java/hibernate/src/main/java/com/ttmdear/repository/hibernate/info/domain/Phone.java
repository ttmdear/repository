package com.ttmdear.repository.hibernate.info.domain;

import com.ttmdear.repository.hibernate.core.domain.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "INF_PHONE")
@Data
public class Phone extends Entity {
    private String value;

    @Setter(AccessLevel.NONE)
    @Column(name = "OWNER_ID")
    private String ownerId;
}
