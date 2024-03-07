package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E01_Mono_to_Flux {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1023);
        Flux<Integer> flux = Flux.from(mono);

        flux.subscribe(result -> {
            sleep(1000);
            log("result %s", result);
        });

        log("end");
    }
}