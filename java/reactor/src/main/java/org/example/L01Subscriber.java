package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class L01Subscriber {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(3, 4, 5);

        flux.subscribe(integer -> {
            System.out.println("onNext " + integer);
        });

        flux.subscribe(new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " + integer);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}