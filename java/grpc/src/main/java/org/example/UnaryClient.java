package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.CreateAccountRequest;

public class UnaryClient {

    public static void main(String[] args) throws InterruptedException {
        new UnaryClient().run();
    }

    public void run() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        BankServiceGrpc.BankServiceBlockingStub service = BankServiceGrpc.newBlockingStub(channel);

        Account account1 = service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1001").build());
        Account account2 = service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1002").build());
        Account account3 = service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1003").build());

        System.out.printf("account1 create %s%n", account1.getAccountId());
        System.out.printf("account2 create %s%n", account2.getAccountId());
        System.out.printf("account3 create %s%n", account3.getAccountId());
    }
}