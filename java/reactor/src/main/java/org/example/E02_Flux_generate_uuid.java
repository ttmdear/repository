package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.UUID;
import java.util.function.Consumer;

import static org.example.Util.log;

public class E02_Flux_generate_uuid {
    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(new Consumer<>() {
            @Override
            public void accept(SynchronousSink<String> sink) {
                sink.next(UUID.randomUUID().toString());

                // We can call complete when stream is finished
                // sink.complete();
            }
        });

        flux
            .take(10)
            .subscribe(uuid -> {
            log("UUID %s", uuid);
        });
    }
}