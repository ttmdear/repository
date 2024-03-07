package org.example;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class E01_Mono_Block {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1023);

        Integer resutl = mono.subscribeOn(Schedulers.boundedElastic())
            .block();

        Util.log("result %s", resutl);
    }
}