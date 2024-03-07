package org.example;

import reactor.core.publisher.Flux;

import java.util.List;

import static org.example.Util.log;

public class E02_Flux_fromStream {

    public static void main(String[] args) {
        new E02_Flux_fromStream().runstreamHasAlreadyBeenOperatedUponOrClosed();
        new E02_Flux_fromStream().run();
    }

    public void run() {
        List<Integer> list = List.of(10, 20, 300, 500);
        Flux<Integer> flux = Flux.fromStream(() -> list.stream());

        flux.subscribe(integer ->
            log("onNext %s", integer)
        );

        flux.subscribe(integer ->
            log("onNext %s", integer)
        );

        log("end");
    }

    public void runstreamHasAlreadyBeenOperatedUponOrClosed() {
        List<Integer> list = List.of(10, 20, 300, 500);
        Flux<Integer> flux = Flux.fromStream(list.stream());

        flux.subscribe(integer ->
            log("onNext %s", integer)
        );

        // ERROR
        flux.subscribe(integer ->
            log("onNext %s", integer)
        );

        log("end");
    }


}