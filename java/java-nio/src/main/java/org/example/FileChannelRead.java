package org.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannelRead {
    public static void main(String[] args) throws IOException {
        new FileChannelRead().run();
    }

    public void run() throws IOException {
        try (RandomAccessFile reader = new RandomAccessFile("C:\\home\\repository\\java\\java-nio\\src\\main\\resources\\file-m4.txt", "r");
             FileChannel channel = reader.getChannel();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            int bufferSize = 1024;

            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }

            ByteBuffer buff = ByteBuffer.allocate(bufferSize);

            while (channel.read(buff) > 0) {
                out.write(buff.array(), 0, buff.position());
                buff.clear();
            }

            System.out.println(out.toString(StandardCharsets.UTF_8));
        }
    }
}

