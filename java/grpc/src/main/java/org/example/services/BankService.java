package org.example.services;

import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.bank.proto.Account;
import org.example.bank.proto.Accounts;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.CreateAccountRequest;
import org.example.bank.proto.Event;
import org.example.bank.proto.GetAccountRequest;
import org.example.bank.proto.Money;
import org.example.bank.proto.Note;
import org.example.bank.proto.Notes;
import org.example.bank.proto.WithdrawRequest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    private static final Map<String, Account> ACCOUNTS = new ConcurrentHashMap<>();

    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<Account> responseObserver) {
        if (request.getAccountId().isEmpty()) {
            responseObserver.onError(new RuntimeException("Account is required."));
            responseObserver.onCompleted();
            return;
        }

        if (ACCOUNTS.containsKey(request.getAccountId())) {
            responseObserver.onError(new RuntimeException("The account %s exists.".formatted(request.getAccountId())));
        }

        Account account = Account.newBuilder()
            .setAccountId(request.getAccountId())
            .setBalance(0)
            .build();

        ACCOUNTS.put(account.getAccountId(), account);

        responseObserver.onNext(account);
        responseObserver.onCompleted();
    }

    @Override
    public void getAccount(GetAccountRequest request, StreamObserver<Account> responseObserver) {
        if (!ACCOUNTS.containsKey(request.getAccountId())) {
            responseObserver.onError(new RuntimeException("The account %s not exists.".formatted(request.getAccountId())));
        }

        responseObserver.onNext(ACCOUNTS.get(request.getAccountId()));
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAccounts(Empty request, StreamObserver<Accounts> responseObserver) {
        Accounts accounts = Accounts.newBuilder()
            .addAllAccounts(ACCOUNTS.values())
            .build();

        responseObserver.onNext(accounts);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAccountStream(Empty request, StreamObserver<Account> responseObserver) {
        for (Account value : ACCOUNTS.values()) {
            responseObserver.onNext(value);
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        }

        responseObserver.onCompleted();
    }
}
