package org.example;

import reactor.core.publisher.Flux;

import static org.example.Util.log;

public class E02_Flux_create_own_stream {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.create(sink -> {
            log("create");

            for (int i = 0; i < 10; i++) {
                if (sink.isCancelled()) {
                    return;
                }

                log("next %s", i);
                sink.next(i);
            }

            sink.complete();
        });

        flux.take(5)
            .subscribe(integer -> {
                log("1: onNext %s", integer);
            });
    }
}