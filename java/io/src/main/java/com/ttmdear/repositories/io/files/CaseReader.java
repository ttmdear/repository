package com.ttmdear.repositories.io.files;

import com.sun.deploy.net.proxy.RemoveCommentReader;

import java.io.*;

public class CaseReader {
    public void run() throws IOException {
        // Inicjalizacja strumienia

        // InputStreamReader - czy strumień i interpretuje go jako znaki (String)
        // InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        StringReader reader = new StringReader("Test");
        // CharArrayReader reader = new CharArrayReader(new char[]{'1', '2', '3', '4', '5'});

        // FilterReader
        // RemoveCommentReader reader = new RemoveCommentReader(new StringReader("test\n// comment\nkowalski"));
        // InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/input-test.txt"));

        // PipedWriter pipedWriter = new PipedWriter();
        // PipedReader reader = new PipedReader(pipedWriter);

        // pipedWriter.write(10);
        // pipedWriter.write(20);

        int data;

        while ((data = reader.read()) != -1) System.out.println(data);

        // BufferedReader bufferedReader = new BufferedReader(new StringReader("Test\nJan"));

        // String line;

        // while ((line = bufferedReader.readLine()) != null) System.out.println(line);
    }
}
