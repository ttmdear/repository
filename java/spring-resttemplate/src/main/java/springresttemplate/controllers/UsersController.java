package springresttemplate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springresttemplate.services.jsonplaceholder.JpApiService;
import springresttemplate.services.jsonplaceholder.dto.UserDto;

@RestController
public class UsersController {
    private final JpApiService jpApiService;

    public UsersController(JpApiService jpApiService) {
        this.jpApiService = jpApiService;
    }

    @GetMapping(path = "/users")
    public UserDto[] get() {
        return jpApiService.getUsers();
    }
}
