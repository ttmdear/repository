package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.example.Util.log;

public class E02_Flux_to_Mono {

    public static void main(String[] args) {
        Flux<String> flux = Flux.just("foo", "bar", "cat", "dog");

        Mono<String> mono = flux
            .filter(s -> s.equals("cat"))
            .next();

        mono.subscribe(log());
    }
}