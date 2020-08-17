package com.ttmdear.repositories.io.files;

import java.io.*;

public class WriteStreamFile {
    public void run() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/input-test.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        FileOutputStream fileOutputStream = new FileOutputStream("input-test-copy.txt");

        int data;

        while ((data = inputStreamReader.read()) != -1) {
            fileOutputStream.write(data);
        }

        inputStream.close();
        fileOutputStream.close();
    }
}
