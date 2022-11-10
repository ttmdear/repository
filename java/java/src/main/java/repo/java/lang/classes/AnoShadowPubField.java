package repo.java.lang.classes;

@SuppressWarnings("InnerClassMayBeStatic")
public class AnoShadowPubField {
    public static void main(String[] args) {
        NestedStaticA nestedStaticA = new NestedStaticA() {
            public String field = "fieldB";
        };

        System.out.printf(nestedStaticA.field);
    }

    public static class NestedStaticA {
        public String field = "field";
    }
}
