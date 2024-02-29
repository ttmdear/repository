package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.CreateAccountRequest;
import org.example.bank.proto.DepositRequest;
import org.example.bank.proto.Money;

import java.util.concurrent.CountDownLatch;

public class StreamOutClient {

    public static void main(String[] args) throws InterruptedException {
        new StreamOutClient().run();
    }

    public void run() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        BankServiceGrpc.newBlockingStub(channel)
            .createAccount(CreateAccountRequest.newBuilder().setAccountId("1001").build());

        BankServiceGrpc.BankServiceStub service = BankServiceGrpc.newStub(channel);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        StreamObserver<DepositRequest> streamOut = service.deposit(new StreamObserver<Account>() {
            @Override
            public void onNext(Account account) {
                System.out.printf("deposit finished, new balance %s%n", account.getBalance());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("deposit onCompleted");
                countDownLatch.countDown();
            }
        });

        streamOut.onNext(DepositRequest.newBuilder().setAccountId("1001").build());
        streamOut.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setAmount(100).build()).build());
        streamOut.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setAmount(100).build()).build());
        streamOut.onNext(DepositRequest.newBuilder().setMoney(Money.newBuilder().setAmount(100).build()).build());
        streamOut.onCompleted();

        countDownLatch.await();
    }
}