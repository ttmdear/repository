package com.ttmdear.jokes.learning.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("/learning/interceptors")
@Component("learningInterceptorsIndexController")
public class IndexController {

    @RequestMapping("")
    @ResponseBody
    public String index(ServletRequest servletRequest) {

        return "koniec";
    }
}
