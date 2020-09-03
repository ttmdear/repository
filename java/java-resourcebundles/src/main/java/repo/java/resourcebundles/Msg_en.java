package repo.java.resourcebundles;

import java.util.ListResourceBundle;

public class Msg_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"day", "day"},
            {"days", "days"},
        };
    }
}
