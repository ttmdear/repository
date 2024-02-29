package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.services.BankService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
            .addService(new BankService())
            .build();

        server.start();

        System.out.println("Server started on %s".formatted(8080));

        server.awaitTermination();
    }
}