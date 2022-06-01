package repo.reactor;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        // Start a cold Publisher which emits 0,1,2 every sec.
        Flux<Long> flux = Flux.create(sink -> {
            for (long i = 0; i < 3; i++) {
                sink.next(i);
            }
        });

        // Make the Publisher Hot
        ConnectableFlux<Long> connectableFlux = flux.publish();

        // Now that we have a handle on the hot Publisher
        // Let's subscribe to that with multiple subscribers.
        connectableFlux.subscribe(i -> System.out.println("first_subscriber received value:" + i));

        // Start firing events with .connect() on the published flux.
        connectableFlux.connect();

        sleep(3_000);
        // Let a second subscriber come after some time 3 secs here.
        connectableFlux.subscribe(i -> System.out.println("second_subscriber received value:" + i));
    }

    private static void sleep(long mil) {
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void ptid(String m) {
        System.out.printf(String.format("thread %s - %s\n", Thread.currentThread().getName(), m));
    }
}
