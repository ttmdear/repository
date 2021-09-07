package com.ttmdear.petclinic.web.controllers;

import com.ttmdear.petclinic.data.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {
    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/", "index", "index.html"})
    public String index(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
