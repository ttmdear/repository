package repo.java.lang.classes;

@SuppressWarnings("InnerClassMayBeStatic")
public class DeepNested {
    public static void main(String[] args) {
        Interface interfaceA = new Interface() {
            public String field = "field";
            public static String FIELD = "FIELD";
            public static final String FIELD_FINAL = "FINAL";

            class NestedInstanceA {}
            static class NestedStatic {}
            public static interface Interface {}
            static enum Enum {A, B}

            @Override
            public int hashCode() {
                System.out.printf(FIELD + FIELD_FINAL, field);

                NestedInstanceA nestedInstanceA = new NestedInstanceA();
                NestedStatic nestedStatic = new NestedStatic();
                Interface interfaceA = new Interface() {
                    @Override
                    public int hashCode() {
                        return super.hashCode();
                    }
                };

                Enum enumA = Enum.A;
                return super.hashCode();
            }
        };
    }

    public class NestedInstance {
        public static String FIELD = "FIELD";
        public static final String FIELD_FINAL = "FINAL";

        public class NestedInstanceA {}
        public static class NestedStatic {}
        public static interface Interface {}
        public static enum Enum {}
    }

    public static class NestedStatic {
        public static String FIELD = "FIELD";
        public static final String FIELD_FINAL = "FINAL";

        public class NestedInstance {}
        public static class NestedStaticA {}
        public static interface Interface {}
        public static enum Enum {}
    }

    public static interface Interface {
        public static String FIELD = "FIELD";
        public static final String FIELD_FINAL = "FINAL";

        public class NestedInstance {}
        public static class NestedStatic {}
        public static interface InterfaceA {}
        public static enum Enum {}
    }

    public static enum Enum {
        A, B;

        public static String FIELD = "FIELD";
        public static final String FIELD_FINAL = "FINAL";

        public class NestedInstance {}
        public static class NestedStatic {}
        public static interface Interface {}
        public static enum EnumA {}
    }
}
