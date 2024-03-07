package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class E03_Stock_price_publisher {
    public static void main(String[] args) {
        getPricePublisher()
            .subscribe(new Subscriber<Integer>() {
                private final AtomicReference<Subscription> subscriptionRef = new AtomicReference<>();

                @Override
                public void onSubscribe(Subscription subscription) {
                    subscriptionRef.set(subscription);
                    subscription.request(1);
                }

                @Override
                public void onNext(Integer integer) {
                    Util.log("onNext %s", integer);
                    subscriptionRef.get().request(1);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("onError");
                }

                @Override
                public void onComplete() {
                    System.out.println("onComplete");
                }
            });

        Util.sleep(60000);
    }

    public static Flux<Integer> getPricePublisher() {
        return Flux.interval(Duration.ofSeconds(1))
            .map(i -> {
                int i1 = new Random().nextInt(100);
                Util.log("next price %s", i1);
                return i1;
            }).subscribeOn(Schedulers.boundedElastic());
    }
}