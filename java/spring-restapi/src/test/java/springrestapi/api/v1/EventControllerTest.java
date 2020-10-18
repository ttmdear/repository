package springrestapi.api.v1;

import java.util.UUID;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import springrestapi.api.StandardResponse;
import springrestapi.domain.events.Event;
import springrestapi.repositories.events.EventRepository;
import static org.junit.jupiter.api.Assertions.*;

class EventControllerTest {
    private WebTestClient webTestClient;
    private EventRepository eventRepository;
    private EventController eventController;

    @BeforeEach
    public void setUp() {
        eventRepository = Mockito.mock(EventRepository.class);
        eventController = new EventController(eventRepository);
        webTestClient = WebTestClient.bindToController(eventController).build();
    }

    @Test
    void getList() {
        Mockito.when(eventRepository.findAll()).thenReturn(Flux.just(
            Event.builder()
                .id(UUID.randomUUID().toString())
                .message("Message one")
                .build()
        ));

        webTestClient.get()
            .uri("/v1/events")
            .exchange()
            .returnResult(Event.class)
            .consumeWith(result -> {
                result.getResponseBody().subscribe(response -> {
                    System.out.println(response);
                });
            });
    }

    @Test
    void getById() {
    }
}