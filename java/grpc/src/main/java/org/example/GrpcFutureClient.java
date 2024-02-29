package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.BankServiceGrpc.BankServiceStub;
import org.example.bank.proto.Event;

import java.time.Duration;

public class GrpcFutureClient {
    public static void main(String[] args) throws InterruptedException {
        // ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        //     .usePlaintext()
        //     .build();

        // BankServiceStub bankServiceStub = BankServiceGrpc.newFutureStub(channel);

        // EmptyRequest emptyRequest = EmptyRequest.newBuilder().build();

        // bankServiceStub.getAccountEvents(emptyRequest, new StreamObserver<Event>() {
        //     @Override
        //     public void onNext(Event event) {
        //         System.out.println("event " + event.getEventId());
        //     }

        //     @Override
        //     public void onError(Throwable throwable) {

        //     }

        //     @Override
        //     public void onCompleted() {
        //         System.out.println("compile");
        //     }
        // });

        // Thread.sleep(Duration.ofSeconds(2));
    }
}