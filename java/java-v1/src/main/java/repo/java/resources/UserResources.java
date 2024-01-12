package repo.java.resources;

import java.util.ListResourceBundle;

public class UserResources extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"database.user", "foo"},
            {"database.password", "xyz"},
            {"database.host", "localhost"}
        };
    }
}
