package com.ttmdear.repositories.io.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CaseOutputStreamWriter {
    public void run() throws IOException {
        InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/input-test.txt"));

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("input-test-copy.txt"));

        int data;
        while ((data = reader.read()) != -1) writer.append((char)data);

        writer.flush();
    }
}
