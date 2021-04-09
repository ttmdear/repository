package repo.java.unsafe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        testReadWritePrivateField();
        testReadWritePublicField();
    }

    private static void testReadWritePrivateField() throws IllegalAccessException, NoSuchFieldException {
        User user = new User(10);

        VarHandle USER_AGE = MethodHandles.privateLookupIn(User.class, MethodHandles.lookup())
            .findVarHandle(User.class, "age", int.class);

        System.out.println(USER_AGE.get(user));

        USER_AGE.set(user, 20);

        System.out.println(user.getAge());
    }

    private static void testReadWritePublicField() throws NoSuchFieldException, IllegalAccessException {
        User user = new User(10);

        VarHandle USER_FIRST_NAME = MethodHandles.lookup()
            .in(User.class)
            .findVarHandle(User.class, "firstName", String.class);

        System.out.println(USER_FIRST_NAME.get(user));

        USER_FIRST_NAME.set(user, "Paweł");

        System.out.println(user.firstName);

    }

    public static class User {
        public String firstName;
        private int age;

        public User(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }
}
