package spring5webflux.repositories.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring5webflux.domain.User;
import spring5webflux.repositories.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static List<User> users;

    static {
        users = Arrays.asList(
            new User(UUID.randomUUID().toString(), "Paweł", "Kowalski"),
            new User(UUID.randomUUID().toString(), "Krystian", "Wrona"),
            new User(UUID.randomUUID().toString(), "Dominika", "Żarłak"),
            new User(UUID.randomUUID().toString(), "Damian", "Grzebalski")
        );
    }

    @Override
    public Flux<User> findAll() {
        return Flux.fromIterable(users).delayElements(Duration.ofSeconds(1));
    }

    @Override
    public Mono<User> findById(String id) {
        return users.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            .map(Mono::just)
            .orElseGet(Mono::empty);
    }
}
