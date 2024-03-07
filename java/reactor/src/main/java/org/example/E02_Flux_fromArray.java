package org.example;

import reactor.core.publisher.Flux;

import static org.example.Util.log;

public class E02_Flux_fromArray {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.fromArray(new Integer[]{3, 2, 5});

        flux.subscribe(integer ->
            log("onNext %s", integer)
        );

        log("end");
    }
}