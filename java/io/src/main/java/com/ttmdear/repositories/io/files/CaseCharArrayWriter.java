package com.ttmdear.repositories.io.files;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaseCharArrayWriter {
    public void run() throws IOException {
        InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/input-test.txt"));

        CharArrayWriter writer = new CharArrayWriter();

        int data;
        while ((data = reader.read()) != -1) writer.append((char) data);

        System.out.println(writer.toString());
    }
}
