package repo.java.lang.classes.shadowing;

public class MainClass {
    private String name = "MainClass";

    public String getName() {
        return name;
    }

    public class NestedClass {
        private String name = "NestedClass";

        public String getName() {
            return name;
        }

        public String getMainName() {
            return MainClass.this.name;
        }
    }

    public static class NestedStaticClass {
        private String name = "NestedStaticClass";

        public String getName() {
            return name;
        }

        public String getMainName() {
            // return MainClass.this.name;
            //        ^^^^^^^^^^^^^^ - cannot ref to MainClass
            return null;
        }
    }
}
