package repo.java.lang.classes.shadowing;

public class MainClass2 {
    private static String STATIC_VAR = "MainClass2";

    public String getVar() {
        return STATIC_VAR;
    }

    public class NestedClass {
        private static String STATIC_VAR = "NestedClass";

        public String getVar() {
            return STATIC_VAR;
        }

        public String getMainVar() {
            return MainClass2.STATIC_VAR;
        }
    }

    public static class NestedStaticClass {
        private static String STATIC_VAR = "NestedStaticClass";

        public String getVar() {
            return STATIC_VAR;
        }

        public String getMainVar() {
            return MainClass2.STATIC_VAR;
        }
    }
}
