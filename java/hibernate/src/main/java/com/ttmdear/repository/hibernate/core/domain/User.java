package com.ttmdear.repository.hibernate.core.domain;

import com.ttmdear.repository.hibernate.core.converters.UserTypeConverter;
import com.ttmdear.repository.hibernate.info.domain.Phone;
import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "CORE_USER")
@Data
@NamedNativeQuery(name = "USER_ALL", query = "SELECT * FROM CORE_USER", resultClass = User.class)
@NamedQueries({
        @NamedQuery(name = "CORE_USER.ACTIVE_USERS", query = "FROM User WHERE status = 'ACTIVE'")
})
public class User extends Entity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column
    @Convert(converter = UserTypeConverter.class)
    private UserType type;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns(value = @JoinColumn(name = "OWNER_ID"), foreignKey = @ForeignKey(name = "none"))
    private Set<Phone> phones = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "INF_PHONE", joinColumns = {
            @JoinColumn(name = "OWNER_ID")
    })
    @Column(name = "value")
    @Transient
    private Set<String> phonesValues;
}
