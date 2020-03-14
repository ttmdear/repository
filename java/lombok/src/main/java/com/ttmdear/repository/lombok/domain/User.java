package com.ttmdear.repository.lombok.domain;

import lombok.*;
import lombok.extern.java.Log;

import javax.swing.text.html.HTMLDocument;
import java.util.concurrent.locks.Lock;
import java.util.logging.LogRecord;

@ToString
@EqualsAndHashCode
@Log
public class User {
    @Getter @Setter
    private String id;

    @Getter()
    private String name;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    private String levelOfSure;
    private Integer levelOfSureLock = new Integer(1);

    private Integer lockA = new Integer(1);
    private Integer lockB = new Integer(1);

    public void setLevelOfSure(String levelOfSure) {
        synchronized (levelOfSureLock) {
            this.levelOfSure = levelOfSure;

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getLevelOfSure() {
        synchronized (levelOfSureLock) {
            return levelOfSure;
        }
    }

    public String getFullName() {
        // Tworzona jest zmienne final String fullName, typ zmiennej jest wywnioskowany
        val fullName = firstName + " " + lastName;

        return fullName;
    }

    @Synchronized("lockA")
    public void sendToEmail() throws InterruptedException {
        log.info(String.format("Rozpoczynam wysyłanie emaila [%s]. Wątek [%s].", id, Thread.currentThread().getId()));

        Thread.sleep(5000);
    }

    @Synchronized("lockB")
    public void sendToNotification() throws InterruptedException {
        log.info(String.format("Rozpoczynam wysyłanie powiadomień [%s]. Wątek [%s].", id, Thread.currentThread().getId()));

        Thread.sleep(5000);
    }

    public void setId(String id) {
        this.id = id + "n";
    }
}
