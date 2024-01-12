package repo.java.lang.classes.nested;

public class PublicClass {
    private static final String NAME = "APP";

    public static String PUBLIC_STATIC = "main";

    private String id;

    public PublicClass(String id) {
        this.id = id;
    }

    public PublicInnerClass getPublicInnerClass() {
        return this.new PublicInnerClass();
    }

    public PublicInnerClass getPublicInnerClass2() {
        return new PublicInnerClass();
    }

    public PublicStaticInnerClass getPublicStaticInnerClass() {
        return new PublicStaticInnerClass();
    }

    public class PublicInnerClass {
        public static final String PUBLIC_STATIC_NESTED_FINAL = "nested";

        public static String PUBLIC_STATIC_NESTED = "nested";

        public static void doStatic() {

        }

        public interface NestedNestedInterface { }

        public enum NestedNestedEnum { A, B }

        public static class NestedUser {}

        public class NestedUser2 {}

        public void doSth() {
            System.out.print(NAME);
            System.out.print(id);
        }
    }

    public static class PublicStaticInnerClass {
        public void doSth() {
            System.out.print(NAME);
            // System.out.print(id);
            //                  ^^ - cannot reference to non static element in static inner class
        }
    }
}
