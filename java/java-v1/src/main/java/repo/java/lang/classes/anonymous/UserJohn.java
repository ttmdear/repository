package repo.java.lang.classes.anonymous;

public class UserJohn implements User {
    private final String id;
    private final String firstName = "John";
    private final String lastName = "Foo";

    public UserJohn(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
