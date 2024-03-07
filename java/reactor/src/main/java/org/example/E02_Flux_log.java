package org.example;

import reactor.core.publisher.Flux;

import static org.example.Util.log;

public class E02_Flux_log {

    public static void main(String[] args) {
        new E02_Flux_log().run();
    }

    public void run() {
        Flux<String> flux = Flux.range(10, 5)
            .log()
            .map(numer -> "User numer" + numer)
            .log()
            .map(name -> "(" + name + ")");

        flux.subscribe(name ->
            log("onNext %s", name)
        );

        log("end");
    }
}