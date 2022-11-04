package repo.java.lang.classes.nested;

public class PublicClass {
    private static final String NAME = "APP";

    private String id;

    public PublicClass(String id) {
        this.id = id;
    }

    public PublicInnerClass getPublicInnerClass() {
        return this.new PublicInnerClass();
    }

    public PublicStaticInnerClass getPublicStaticInnerClass() {
        return new PublicStaticInnerClass();
    }

    public class PublicInnerClass {
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
