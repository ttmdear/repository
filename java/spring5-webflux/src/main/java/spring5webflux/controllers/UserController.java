package spring5webflux.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring5webflux.domain.User;
import spring5webflux.repositories.UserRepository;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}")
    public Mono<User> getById(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getList() {
        return userRepository.findAll();
    }
}
