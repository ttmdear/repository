package com.ttmdear.repositories.io.files;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadBufferedStream {
    public void run() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/input-test.txt");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        int data;

        while ((data = bufferedInputStream.read()) != -1) {
            System.out.println(data);
        }
    }
}
