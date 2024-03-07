package org.example;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E01_Mono_NonBlocking {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1023);

        mono.subscribeOn(Schedulers.boundedElastic())
            .subscribe(result -> {
                sleep(1000);
                log("result %s", result);
            });

        log("end");
        sleep(2000);
    }
}