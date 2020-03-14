package com.ttmdear.repository.springmvc.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentsController {
    @ModelAttribute(name = "header")
    private Header getHeader() {
        return new Header();
    }

    @ModelAttribute(name = "type")
    private String getType() {
        return "students";
    }

    @GetMapping({"", "/"})
    public String indexAction(@ModelAttribute("mode") ModeDTO mode, Model model) {
        model.addAttribute("status", "active");

        return "students/index";
    }

    private static class Header {
        public String getName() {
            return "John";
        }
    }

    public static class ModeDTO {
        private String mode;

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return mode;
        }
    }
}
