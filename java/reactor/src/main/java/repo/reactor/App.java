package repo.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class App {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(Integer value) {
                System.out.printf("value " + value);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
