package com.ttmdear.repository.springmvc.springmvc.controllers;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;

@Controller
@RequestMapping("/works")
public class WorksController {
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // webDataBinder.setFieldDefaultPrefix("user");

        // Ustawiamy jakie pola mogą być przekazane
        // webDataBinder.setAllowedFields("id", "name");

        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping({"", "/"})
    public String indexAction(@ModelAttribute("input") InputData inputData) {
        return "works/index";
    }

    public static class InputData {
        private String id;
        private String name;
        private String age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            // return name == null ? "null" : name;
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
