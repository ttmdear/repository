package org.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelRead {

    public static void main(String[] args) throws IOException {
        new AsynchronousFileChannelRead().run();
    }

    public void run() throws IOException {
        Path path = Paths.get("C:\\home\\repository\\java\\java-nio\\src\\main\\resources\\file-m4.txt");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        Future<Integer> read = channel.read(buffer, 0);

        while (true) {
            if (read.isDone()) {
                buffer.flip();
                byte[] data = new byte[buffer.limit()];
                buffer.get(data);
                System.out.println(new String(data));
                buffer.clear();
            }

            // Głowna pętla
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
