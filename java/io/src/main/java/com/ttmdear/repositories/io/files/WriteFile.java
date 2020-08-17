package com.ttmdear.repositories.io.files;

import java.io.*;

public class WriteFile {
    public void run() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/input-test.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        FileWriter fileWriter = new FileWriter("input-test-copy.txt");

        int data;

        while ((data = inputStreamReader.read()) != -1) {
            fileWriter.write(data);
        }

        inputStream.close();
        fileWriter.close();
    }
}
