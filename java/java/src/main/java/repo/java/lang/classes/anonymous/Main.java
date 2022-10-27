package repo.java.lang.classes.anonymous;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        case1();
        case2();
        caseWrapping();
    }

    private static void case1() {
        User user = new User() {
            @Override
            public String getId() {
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

        print(user);
    }

    private static void case2() {
        User user = new UserJohn("10") {
            @Override
            public String getFirstName() {
                return super.getFirstName() + " EDITED";
            }
        };

        print(user);
    }

    private static void caseWrapping() {
        List<Integer> integers = List.of(1, 2, 3, 4);
        List<Type2> type2List = new ArrayList<>();

        for (Integer integer : integers) {
            type2List.add(new Type2() {
                @Override
                public int getValue() {
                    return integer;
                }
            });
        }

        print(type2List);
    }

    private static void print(User user) {
        System.out.printf("Hello I'm %s %s%n", user.getFirstName(), user.getLastName());
    }

    private static void print(List<Type2> list) {
        for (Type2 type2 : list) {
            System.out.printf("%s%n", type2.getValue());
        }
    }
}
