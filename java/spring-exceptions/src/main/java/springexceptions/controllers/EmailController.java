package springexceptions.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @RequestMapping(value = "/emails/{id}")
    public Long get(@PathVariable Long id) {
        return id;
    }
}
