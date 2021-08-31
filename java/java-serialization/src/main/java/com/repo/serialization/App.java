package com.repo.serialization;

import javafx.animation.Animation;

import java.io.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        new App().run();
    }

    public void run() throws InterruptedException {
        runSimplePersis();
        runWithTransient();
    }

    private void runWithTransient() throws InterruptedException {
        PersistentAnimation persistentAnimation = new PersistentAnimation(5000);

        Thread.sleep(10000);

        System.out.println("persist animation");
        persist(persistentAnimation);

        persistentAnimation.stop();

        System.out.println("unpersist animation");

        persistentAnimation = unpersist();

        System.out.println("unpersist");
    }

    private void runSimplePersis() {
        persist(new PersistentTime());

        PersistentTime time = unpersist();

        System.out.println(time.getTime());
    }

    private void persist(Object object) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        try {
            fileOutputStream = new FileOutputStream("persistentTime.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> T unpersist() {
        T time = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("persistentTime.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

             time = (T) objectInputStream.readObject();

            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return time;
    }
}
