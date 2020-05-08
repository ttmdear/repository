package com.ttmdear.repository.hibernate.core.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Data
abstract public class Entity {
    @Id
    protected String id;

    public Entity() {
        this.id = UUID.randomUUID().toString();
    }
}
