package repo.java.lang.modifiers.pack;

public interface PublicInterface {

    String APP_NAME = "ITP";

    // It's incorrect. PublicInterface cannot be implemented out of package.
    // PackagePrivateInterface create();

    interface PackagePrivateNestedInterface {
    }
}
