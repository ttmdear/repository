package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.function.Consumer;

import static org.example.Util.log;

public class E02_Flux_generate {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.generate(new Consumer<>() {
            private int i = 10;

            @Override
            public void accept(SynchronousSink<Integer> sink) {
                sink.next(i);
                i--;

                if (i == 0) {
                    sink.complete();
                }
            }
        });

        flux.subscribe(integer -> {
            log("1: onNext %s", integer);
        });
    }
}