package com.ttmdear.jokes.guru.controllers;

import com.ttmdear.jokes.guru.services.HelloWorldService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {
    private HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping({""})
    @ResponseBody
    public String index() {
        return helloWorldService.getGreeting();
    }
}
