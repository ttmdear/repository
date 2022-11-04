package repo.java.lang.modifiers;

import repo.java.lang.classes.nested.PublicClass;
import repo.java.lang.modifiers.pack.AbstractClass;
import repo.java.lang.modifiers.pack.PublicInterface;

public class _Main {
    public static void main(String[] args) {

        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void doItAgain() {

            }
        };

        PublicClass.PublicStaticInnerClass publicStaticInnerClass = new PublicClass.PublicStaticInnerClass();

        PublicClass publicClass = new PublicClass("10");

        PublicClass.PublicInnerClass publicInnerClass = publicClass.new PublicInnerClass();
    }
}
