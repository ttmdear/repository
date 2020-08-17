package com.ttmdear.repositories.io;

import com.ttmdear.repositories.io.files.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        new CaseBufferedWriter().run();
        new CaseCharArrayWriter().run();
        new CaseOutputStreamWriter().run();
        new WriteFile().run();
        new WriteStreamFile().run();

        new CaseReader().run();
        new ReadBufferedStream().run();
        new ReadBufferedStreamReader().run();
        new ReadStreamFile().run();
    }
}
