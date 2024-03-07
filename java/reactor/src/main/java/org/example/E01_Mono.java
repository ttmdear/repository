package org.example;

import reactor.core.publisher.Mono;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E01_Mono {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1023);

        mono.subscribe(result -> {
            sleep(1000);
            log("result %s", result);
        });

        log("end");
    }
}