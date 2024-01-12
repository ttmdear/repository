package repo.java.reflection;

import java.lang.reflect.Field;

public class App {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        new App().run();
    }

    public void run() throws NoSuchFieldException, IllegalAccessException {
        User user = new User();

        user.setFirstName("Paweł");
        user.setLastName("Kowalski");
        user.setAge(10);

        printUserPriveFields(user);
    }

    private void printUserPriveFields(User user) throws NoSuchFieldException, IllegalAccessException {
        Field firstName = user.getClass().getDeclaredField("firstName");
        Field lastName = user.getClass().getDeclaredField("lastName");
        Field age = user.getClass().getDeclaredField("age");
        Field substitute = user.getClass().getDeclaredField("substitute");

        firstName.setAccessible(true);
        lastName.setAccessible(true);
        age.setAccessible(true);
        substitute.setAccessible(true);

        System.out.println("firstName " + firstName.get(user));
        System.out.println("lastName " + lastName.get(user));
        System.out.println("age " + age.getInt(user));
        System.out.println("substitute " + substitute.get(user));
    }
}
