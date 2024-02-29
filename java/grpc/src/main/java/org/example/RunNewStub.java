package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.CreateAccountRequest;

import java.util.concurrent.CountDownLatch;

public class RunNewStub {

    public static void main(String[] args) throws InterruptedException {
        new RunNewStub().run();
    }

    public void run() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        BankServiceGrpc.BankServiceStub service = BankServiceGrpc.newStub(channel);

        CountDownLatch countDownLatch = new CountDownLatch(2);

        service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1003").build(), new StreamObserver<Account>() {
            public void onError(Throwable throwable) {
            }

            public void onCompleted() {
            }

            public void onNext(Account account) {
                System.out.printf("account1 create %s%n", account.getAccountId());
                countDownLatch.countDown();
            }
        });

        service.createAccount(CreateAccountRequest.newBuilder().setAccountId("1004").build(), new StreamObserver<Account>() {
            public void onError(Throwable throwable) {
            }

            public void onCompleted() {
            }

            public void onNext(Account account) {
                System.out.printf("account2 create %s%n", account.getAccountId());
                countDownLatch.countDown();
            }

        });

        countDownLatch.await();
    }
}