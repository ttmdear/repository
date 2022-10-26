package repo.java.resources;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void readApplicationProperties() throws Exception {
        System.out.println("readApplicationProperties");
        System.out.println("-----------------------");

        PropertyResourceBundle propertyResourceBundle = new PropertyResourceBundle(getClass().getResourceAsStream("/application.properties"));

        System.out.println(propertyResourceBundle.getString("database.host"));
        System.out.println(propertyResourceBundle.getString("database.user"));
        System.out.println(propertyResourceBundle.getString("database.password"));
        System.out.println(propertyResourceBundle.getString("user.name"));
    }

    private void readListResourceBundle() {
        System.out.println("readListResourceBundle");
        System.out.println("-----------------------");

        ListResourceBundle listResourceBundle = new repo.java.resourcebundles.UserResources();

        System.out.println(listResourceBundle.getString("database.host"));
        System.out.println(listResourceBundle.getString("database.user"));
        System.out.println(listResourceBundle.getString("database.password"));
    }

    private void readLocale() {
        System.out.println("readLocale");
        System.out.println("-----------------------");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("repo.java.resourcebundles.Msg", new Locale("en"));
        System.out.println(resourceBundle.getString("day"));

        resourceBundle = ResourceBundle.getBundle("repo.java.resourcebundles.Msg", new Locale("pl"));
        System.out.println(resourceBundle.getString("day"));

        ResourceBundle messages = PropertyResourceBundle.getBundle("messages", new Locale("pl"));
        System.out.println(messages.getString("base"));
        System.out.println(messages.getString("hello"));
    }

    private void run() throws Exception {
        readApplicationProperties();
        readListResourceBundle();
        readLocale();
    }
}
