package com.ttmdear.repository.jpa.domain;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
public class Audit {
    private LocalDateTime createdOn;

    private String createdBy;

    private LocalDateTime updatedOn;

    private String updatedBy;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
        createdBy = "Jan Kowalski";
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
        updatedBy = "Jan Kowalski";
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
