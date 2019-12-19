package com.ttmdear.jokes.learning.messages;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.sound.midi.Soundbank;
import java.util.Locale;

@Controller
@RequestMapping("/learning/messages")
@Component("learningMessagesIndexController")
public class IndexController {
    private MessageSource messageSource;

    public IndexController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping("")
    @ResponseBody
    public String index(ServletRequest servletRequest) {
        System.out.println("-- Learning messages --");

        return messageSource.getMessage("common.hello-world", new Object[]{"Paweł"}, Locale.forLanguageTag("de"));
    }
}
