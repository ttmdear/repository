package com.ttmdear.repositories.io.files;

import java.io.*;

public class ReadBufferedStreamReader {
    public void run() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/input-test.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
