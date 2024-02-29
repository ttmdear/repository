import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.services.BankService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class IntegrationTest {

    protected Server server;
    protected ManagedChannel channel;

    @BeforeAll
    public void setup() throws IOException, InterruptedException {
        server = ServerBuilder.forPort(8080)
            .addService(new BankService())
            .build();

        server.start();
        // server.awaitTermination();

        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();
    }

    @AfterAll
    public void clean() throws InterruptedException {
        channel.shutdown();
        server.shutdown();

        server = null;
        channel = null;
    }
}
