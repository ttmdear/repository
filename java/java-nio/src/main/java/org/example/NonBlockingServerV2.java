package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NonBlockingServerV2 {
    public static void main(String[] args) throws IOException {
        new NonBlockingServerV2().serve();
    }

    public void serve() throws IOException {
        System.out.println("Listening for connections on port " + 8080);

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket socket = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(8080);
        socket.bind(address);
        serverChannel.configureBlocking(false);

        Selector selector = Selector.open();

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // Oczekujemy na zdarznia
            selector.select();

            Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();

            while (selectionKeyIterator.hasNext()) {
                SelectionKey key = selectionKeyIterator.next();
                selectionKeyIterator.remove();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (key.isReadable()) {

                } else if (key.isWritable()) {

                }
            }
        }
    }
}

