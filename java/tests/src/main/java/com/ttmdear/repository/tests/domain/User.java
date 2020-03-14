package com.ttmdear.repository.tests.domain;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String firstName;

    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;
}
