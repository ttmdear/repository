package org.example;

import reactor.core.publisher.Flux;

public class E02_Flux_Consumer {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(3, 4, 5);

        flux.subscribe(integer -> System.out.println("onNext " + integer));
    }
}