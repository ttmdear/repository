package com.ttmdear.repository.springtransactions.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleId userRoleId;

    private boolean active;
    private Date activeFrom;

    public UserRoleId getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRoleId userRoleId) {
        this.userRoleId = userRoleId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    @Embeddable
    public static class UserRoleId implements Serializable {
        @Enumerated(value = EnumType.STRING)
        private Role role;

        @OneToOne
        private User user;

        public UserRoleId() { }

        public UserRoleId(Role role, User user) {
            this.role = role;
            this.user = user;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}
