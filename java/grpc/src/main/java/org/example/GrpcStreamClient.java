package org.example;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.BankServiceGrpc.BankServiceStub;
import org.example.bank.proto.Event;

import java.time.Duration;

public class GrpcStreamClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        BankServiceStub bankServiceStub = BankServiceGrpc.newStub(channel);

        bankServiceStub.getAllEvents(Empty.newBuilder().build(), new StreamObserver<Event>() {
            @Override
            public void onNext(Event event) {
                System.out.println("event " + event.getEventId());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("compile");
            }
        });

        Thread.sleep(Duration.ofSeconds(2));
    }
}