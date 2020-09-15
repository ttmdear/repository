package com.ttmdear.repository.tests.controllers;

import com.ttmdear.repository.tests.domain.User;
import com.ttmdear.repository.tests.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class IndexController {
    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUser(Model model, @PathVariable("id") String id) {
        return userService.findById(id);
    }

    @RequestMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("users", userService.find());

        return "index";
    }
}
