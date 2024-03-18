package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

import static org.example.Util.log;

public class E02_Flux_generate_xxx {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.generate(
            () -> 1,
            (state, sink) -> {
                sink.next(state + 10);
                return state + 1;
            }
        );

        flux.subscribe(integer -> {
            log("1: onNext %s", integer);
        });
    }
}