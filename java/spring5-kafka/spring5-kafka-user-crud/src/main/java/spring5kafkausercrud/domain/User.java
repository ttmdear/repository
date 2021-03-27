package spring5kafkausercrud.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
}
