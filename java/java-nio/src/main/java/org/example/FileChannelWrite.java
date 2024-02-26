package org.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannelWrite {
    public static void main(String[] args) throws IOException {
        new FileChannelWrite().run();
    }

    public void run() throws IOException {
        try (RandomAccessFile writer = new RandomAccessFile("C:\\home\\repository\\java\\java-nio\\src\\main\\resources\\file-m5.txt", "rw")) {
            FileChannel channel = writer.getChannel();
            ByteBuffer buff = ByteBuffer.wrap("Hello world".getBytes(StandardCharsets.UTF_8));

            channel.write(buff);
        }
    }
}

