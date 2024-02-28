package org.example.bank;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class BankServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
            .addService(new BankService())
            .build();

        server.start();
        server.awaitTermination();
    }
}