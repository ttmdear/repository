package com.ttmdear.repository.tests.domain;

import lombok.*;

import javax.persistence.*;

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
}
