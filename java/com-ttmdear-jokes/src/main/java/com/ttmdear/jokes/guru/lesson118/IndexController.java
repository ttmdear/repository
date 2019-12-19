package com.ttmdear.jokes.guru.lesson118;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("/lesson118")
public class IndexController {

    @RequestMapping({"", "/"})
    public String index() {

        return "index";
    }
}
