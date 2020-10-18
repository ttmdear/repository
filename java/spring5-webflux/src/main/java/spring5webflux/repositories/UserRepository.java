package spring5webflux.repositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring5webflux.domain.User;

public interface UserRepository {
    public Flux<User> findAll();

    public Mono<User> findById(String id);
}
