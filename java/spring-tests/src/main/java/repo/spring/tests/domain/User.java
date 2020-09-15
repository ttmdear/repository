package repo.spring.tests.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    private String firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    public String getFullName() {
        return id + " " + lastName;
    }

    public void validatePermissio(String code) {
        throw new RuntimeException("No permission");
    }
}
