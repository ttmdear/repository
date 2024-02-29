package org.example.services;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.Event;
import org.example.bank.proto.GetAccountRequest;
import org.example.bank.proto.Note;
import org.example.bank.proto.Notes;

import java.util.List;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccount(GetAccountRequest request, StreamObserver<Account> responseObserver) {
        Account account = org.example.bank.proto.Account.newBuilder()
            .setAccountId(request.getAccountId())
            .build();

        responseObserver.onNext(account);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllEvents(Empty request, StreamObserver<Event> responseObserver) {
        List.of(
            Event.newBuilder().setEventId("86d2e2aa-d6d4-11ee-a506-0242ac120002").setPayload("...").build(),
            Event.newBuilder().setEventId("99b5af1a-d6d4-11ee-a506-0242ac120002").setPayload("...").build(),
            Event.newBuilder().setEventId("9d3809d0-d6d4-11ee-a506-0242ac120002").setPayload("...").build(),
            Event.newBuilder().setEventId("a16e4dac-d6d4-11ee-a506-0242ac120002").setPayload("...").build()
        ).forEach(responseObserver::onNext);

        responseObserver.onCompleted();
    }

    @Override
    public void getAllNotes(Empty request, StreamObserver<Notes> responseObserver) {
        Notes notes = Notes.newBuilder()
            .addNote(Note.newBuilder().setNoteId("86d2e2aa-d6d4-11ee-a506-0242ac120002").setPayload("...").build())
            .addNote(Note.newBuilder().setNoteId("99b5af1a-d6d4-11ee-a506-0242ac120002").setPayload("...").build())
            .addNote(Note.newBuilder().setNoteId("9d3809d0-d6d4-11ee-a506-0242ac120002").setPayload("...").build())
            .addNote(Note.newBuilder().setNoteId("a16e4dac-d6d4-11ee-a506-0242ac120002").setPayload("...").build())
            .build();

        responseObserver.onNext(notes);
        responseObserver.onCompleted();
    }
}
