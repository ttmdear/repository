package springexceptions.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springexceptions.domain.User;
import springexceptions.exceptions.NotFound;
import springexceptions.services.UserRepository;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/users/{id}")
    public User get(@PathVariable String id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new NotFound();
        }

        return user;
    }
}
