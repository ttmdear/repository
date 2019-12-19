package com.ttmdear.jokes.guru.controllers;

import com.ttmdear.jokes.guru.services.JokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {
    private JokesService jokesService;

    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping({"", "/"})
    public String get(Model model) {
        // model.addAttribute("jokes", jokesService.findAll());

        model.addAttribute("joke", jokesService.getRandomJoke());

        return "chucknorris";
    }
}
