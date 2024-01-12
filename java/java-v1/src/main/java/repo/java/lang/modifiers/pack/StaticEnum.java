package repo.java.lang.modifiers.pack;

// public static enum StaticEnum
//        ^^^^^^ - incorrect for main enum
public enum StaticEnum {
    A, B;

    public static enum StaticNestedEnum {
        // ^^^^^^ - not needed for nested enum
    }
}
