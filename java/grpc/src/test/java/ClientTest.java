import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.bank.proto.Account;
import org.example.bank.proto.BankServiceGrpc;
import org.example.bank.proto.BankServiceGrpc.BankServiceBlockingStub;
import org.example.bank.proto.GetAccountRequest;
import org.example.bank.proto.Notes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest extends IntegrationTest {

    @Test
    public void getAccountTest() {
        BankServiceBlockingStub bankService = BankServiceGrpc.newBlockingStub(channel);
        GetAccountRequest request = GetAccountRequest.newBuilder()
            .setAccountId("345")
            .build();

        Account account = bankService.getAccount(request);
        assertEquals("345", account.getAccountId());
    }

    @Test
    public void getAllNotesTest() {
        BankServiceBlockingStub bankService = BankServiceGrpc.newBlockingStub(channel);
        GetAccountRequest request = GetAccountRequest.newBuilder()
            .setAccountId("345")
            .build();

        Notes notes = bankService.getAllNotes(Empty.newBuilder().build());

        assertEquals(4, notes.getNoteList().size());
    }
}
