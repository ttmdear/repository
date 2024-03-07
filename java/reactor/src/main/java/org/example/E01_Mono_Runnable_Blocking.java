package org.example;

import reactor.core.publisher.Mono;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E01_Mono_Runnable_Blocking {
    public static void main(String[] args) {
        Mono<Void> mono = Mono.fromRunnable(() -> {
            log("start process");
            sleep(2000);
            log("end process");
        });

        mono.subscribe();

        log("end");
    }
}