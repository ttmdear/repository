package org.example;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E02_Flux_interval_slow_down_stream {

    public static void main(String[] args) {
        new E02_Flux_interval_slow_down_stream().run();
    }

    public void run() {
        Flux.interval(Duration.ofSeconds(1))
            .subscribeOn(Schedulers.boundedElastic())
            .subscribe(result -> {

            });

        sleep(100000);
    }
}