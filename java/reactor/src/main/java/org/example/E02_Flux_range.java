package org.example;

import reactor.core.publisher.Flux;

import static org.example.Util.log;

public class E02_Flux_range {

    public static void main(String[] args) {
        new E02_Flux_range().run();
    }

    public void run() {
        Flux<Integer> flux = Flux.range(10, 10);

        flux.subscribe(integer ->
            log("onNext %s", integer)
        );

        flux.subscribe(integer ->
            log("onNext %s", integer)
        );

        log("end");
    }
}