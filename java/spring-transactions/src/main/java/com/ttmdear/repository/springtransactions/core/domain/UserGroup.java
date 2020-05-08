package com.ttmdear.repository.springtransactions.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import static com.ttmdear.repository.springtransactions.core.domain.UserGroup.*;

@Entity
@IdClass(UserGroupId.class)
@Setter
@Getter
public class UserGroup {
    @Id
    @Column(name = "USER_ID")
    private String userId ;

    @Id
    @Enumerated
    @Column(name = "GR")
    private Group group;

    private Date activeFrom;

    public static class UserGroupId implements Serializable {
        private String userId ;
        private Group group;

        public UserGroupId() { }

        public UserGroupId(String userId, Group group) {
            this.userId = userId;
            this.group = group;
        }
    }
}

