package com.repository.java.examples.illegaldev.objectstate;

public class User {

    private String id;
    private String login;
    private String email;

    public User(String id, String login, String email) {
        this.login = login;
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
