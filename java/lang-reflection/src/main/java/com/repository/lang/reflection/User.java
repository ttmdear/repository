package com.repository.lang.reflection;

public class User {
    private int age;
    private String firstName;
    private String lastName;
    private User substitute;

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public User getSubstitute() {
        return substitute;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubstitute(User substitute) {
        this.substitute = substitute;
    }
}
