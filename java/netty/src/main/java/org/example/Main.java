package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8080);

        // ByteBuffer

        while (true) {
            Socket socket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(() -> {
                try {
                    String line = null;

                    while (!(line = reader.readLine()).equals("")) {
                        System.out.println(line);
                    }

                    StringBuilder body = new StringBuilder();

                    for (int i = 0; i < 5; i++) {
                        body.append((char) reader.read());
                    }

                    System.out.println(body);

                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.write("HTTP/1.1 200 OK\r\n");
                    writer.write("Content-Type: text/html\r\n");
                    writer.write("\r\n");
                    writer.flush();

                    reader.close();
                    writer.close();
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}