package com.repository.classloader;

public class App {
    public static void main(String[] args)
            throws ClassNotFoundException {
        // // Klasa zostanie odnaleziona
        // out.println(Class.forName(
        //     "com.repo.classloader.App",
        //     true,
        //     App.class.getClassLoader())
        // );

        // // Klasa nie zostanie odnaleziona, ponieważ parent nie ma dostępu do klas wczytanych przez
        // // podrzędny ClassLoader.
        // out.println(Class.forName(
        //     "com.repo.classloader.App",
        //     true,
        //     App.class.getClassLoader().getParent())
        // );

        Thread.currentThread().setContextClassLoader(new CustomClassLoader());

        new UserService();

        // Thread.currentThread().set
        // Ustawiam class loader
    }
}
