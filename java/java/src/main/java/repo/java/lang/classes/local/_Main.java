package repo.java.lang.classes.local;

import repo.java.lang.classes.anonymous.Type2;
import repo.java.lang.classes.anonymous.User;
import repo.java.lang.classes.anonymous.UserJohn;

import java.util.ArrayList;
import java.util.List;

public class _Main {
    public static void main(String[] args) {
        caseStaticElements();
    }

    private static void caseStaticElements() {
        User user = new User() {
            private static String NAME = "NAME";
            private static final String NAME_FINAL = "NAE";

            static {
                // Static block
            }

            public static void doSth() {
            }

            {
                // Initialization block
            }

            @Override
            public String getId() {
                doSth();

                return "10";
            }

            @Override
            public String getFirstName() {
                return "John";
            }

            @Override
            public String getLastName() {
                return "Foo";
            }
        };

        user.getId();
    }
}
