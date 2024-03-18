package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
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
//        Flux.interval(Duration.ofSeconds(1))
//            .subscribeOn(Schedulers.boundedElastic())
//            .subscribe(result -> {
//                Util.log("result %s", result);
//            });

        Flux.interval(Duration.ofSeconds(1))
            .subscribe(new Subscriber<Long>() {
                private Subscription subscription;

                @Override
                public void onSubscribe(Subscription subscription) {
                    this.subscription = subscription;
                    subscription.request(1);
                }

                @Override
                public void onNext(Long result) {
                    Util.log("result %s", result);
                    subscription.request(1);
                    Util.sleep(5000);
                }

                @Override
                public void onError(Throwable throwable) { }

                @Override
                public void onComplete() { }
            });

        sleep(100000);
    }
}