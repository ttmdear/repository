package org.example.services;

import io.grpc.stub.StreamObserver;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.GetAccountRequest;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccount(GetAccountRequest request, StreamObserver<Account> responseObserver) {
        Account account = org.example.bank.proto.Account.newBuilder()
            .setAccountId(request.getAccountId())
            .build();

        responseObserver.onNext(account);
        responseObserver.onCompleted();
    }
}
