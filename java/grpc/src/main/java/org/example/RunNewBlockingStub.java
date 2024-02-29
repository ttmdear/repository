package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.CreateAccountRequest;

public class RunNewBlockingStub {

    public static void main(String[] args) throws InterruptedException {
        new RunNewBlockingStub().run();
    }

    public void run() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        BankServiceGrpc.BankServiceBlockingStub service = BankServiceGrpc.newBlockingStub(channel);

        Account account1 = service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1001").build());
        Account account2 = service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1002").build());
        Account account3 = service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1003").build());

        System.out.println("account1 create %s".formatted(account1.getAccountId()));
        System.out.println("account2 create %s".formatted(account2.getAccountId()));
        System.out.println("account3 create %s".formatted(account3.getAccountId()));
    }
}