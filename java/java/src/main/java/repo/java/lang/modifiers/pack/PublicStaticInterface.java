package repo.java.lang.modifiers.pack;

// public static interface PublicStaticInterface {
//        ^^^^^^ incorrect for main class
public interface PublicStaticInterface {

    String APP_NAME = "ITP";

    // It's incorrect. PublicInterface cannot be implemented out of package.
    // PackagePrivateInterface create();

    static interface PackagePrivateNestedInterface {
    // ^^^ - not need but allowed
    }
}
