package com.ttmdear.repositories.io.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

public class CaseBufferedWriter {
    public void run() throws IOException {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);

        writer.write("Paweł");
        writer.newLine();
        writer.write("!@#$");

        writer.flush();

        System.out.println(stringWriter.toString());
    }
}
