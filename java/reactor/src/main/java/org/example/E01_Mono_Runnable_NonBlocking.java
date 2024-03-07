package org.example;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E01_Mono_Runnable_NonBlocking {
    public static void main(String[] args) {
        Mono<Void> mono = Mono.fromRunnable(() -> {
            log("start process");
            sleep(2000);
            log("end process");
        });

        mono.subscribeOn(Schedulers.boundedElastic())
            .subscribe();

        log("end");

        sleep(3000);
    }
}