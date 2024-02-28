package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.BankServiceGrpc.BankServiceBlockingStub;
import org.example.bank.proto.GetAccountRequest;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        BankServiceBlockingStub bankServiceBlockingStub = BankServiceGrpc.newBlockingStub(channel);

        GetAccountRequest request = GetAccountRequest.newBuilder()
            .setAccountId("345")
            .build();

        Account account = bankServiceBlockingStub.getAccount(request);
    }
}