package spring5aop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import spring5aop.domain.User;
import spring5aop.services.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String getUser(@PathVariable String id) {
        User user = userService.findById(id);

        if (user == null) {
            return "no found";
        } else {
            return user.getId();
        }
    }
}
