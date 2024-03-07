package org.example;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E02_Flux_interval {

    public static void main(String[] args) {
        new E02_Flux_interval().run();
    }

    public void run() {
        Flux.interval(Duration.ofSeconds(2))
            .subscribe(result -> {
                log("value %s", result);
            });

        sleep(10000);
        log("end");
    }
}