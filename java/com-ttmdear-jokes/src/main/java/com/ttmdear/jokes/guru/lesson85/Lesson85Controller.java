package com.ttmdear.jokes.guru.lesson85;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson-85")
public class Lesson85Controller {
    private ApplicationContext applicationContext;

    public Lesson85Controller(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping("")
    @ResponseBody
    public String index() {
        CounterService a = applicationContext.getBean(CounterService.class);
        CounterService b = applicationContext.getBean(CounterService.class);

        return String.format("%s, %s", a.getId(), b.getId());
    }
}
