package org.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelReadV2 {

    public static void main(String[] args) throws IOException {
        new AsynchronousFileChannelReadV2().run();
    }

    public void run() throws IOException {
        Path path = Paths.get("C:\\home\\repository\\java\\java-nio\\src\\main\\resources\\file-m4.txt");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        channel.read(buffer, 0, buffer, new CompletionHandler<>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.err.println("Błąd odczytu pliku.");
            }
        });
    }
}
