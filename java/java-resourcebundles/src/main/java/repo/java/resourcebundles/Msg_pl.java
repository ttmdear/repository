package repo.java.resourcebundles;

import java.util.ListResourceBundle;

public class Msg_pl extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"day", "dzień"},
            {"days", "dni"},
        };
    }
}
