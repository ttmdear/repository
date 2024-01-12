package com.repository.java.examples.illegaldev.objectstate;

@
public class CreateUser {

    public final String login;
    public final String email;

    private CreateUser(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public static CreateUser createWithLogin(String login, String email) {
        return new CreateUser(login, email);
    }

    public static CreateUser createWithNoLogin(String email) {
        return new CreateUser(null, email);
    }
}
