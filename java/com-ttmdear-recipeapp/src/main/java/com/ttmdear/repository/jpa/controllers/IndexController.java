package com.ttmdear.repository.jpa.controllers;

import com.ttmdear.repository.jpa.domain.User;
import com.ttmdear.repository.jpa.repositories.UserRepository;
import com.ttmdear.repository.jpa.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class IndexController {
    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {

        Optional<User> user = Optional.of(userService.getUser());

        if (user.isPresent()) {
            return String.format("Hello, I'm %s.", user.get().getFirstName());
        } else {
            return "User not found.";
        }
    }
}
