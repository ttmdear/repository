package com.ttmdear.jokes.guru.controllers;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesDirectlyController {
    private ChuckNorrisQuotes chuckNorrisQuotes;

    public JokesDirectlyController(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    @RequestMapping("/jokes-direct")
    public String get(Model model) {
        model.addAttribute("joke", chuckNorrisQuotes.getRandomQuote());

        return "chucknorris-direct";
    }
}
