package org.example;

import reactor.core.publisher.Mono;

import static org.example.Util.log;
import static org.example.Util.sleep;

public class E01_Mono_Supplier_Blocking {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.fromSupplier(() -> {
            log("start supplier");
            return 23434;
        });

        mono.subscribe(integer -> {
            log("result %s", integer);
        });

        log("end");
    }
}