package com.ttmdear.repositories.io.files;

import java.io.IOException;
import java.io.InputStream;

public class ReadStreamFile {
    public void run() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/input-test.txt");

        int data;

        while ((data = inputStream.read()) != -1) {
            System.out.println((char)data);
        }

        inputStream.close();
    }
}
