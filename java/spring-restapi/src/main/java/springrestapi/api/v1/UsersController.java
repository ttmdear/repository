package springrestapi.api.v1;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springrestapi.api.v1.mappers.UserMapper;
import springrestapi.domain.user.core.Gender;
import springrestapi.domain.user.core.User;
import springrestapi.services.UserService;

@RestController
@RequestMapping(BaseController.BASE_URL)
public class UsersController extends BaseController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> get() {
        return prepareResponse(UserMapper.INSTANCE.map(userService.findAll()));
    }

    @PostMapping("/users")
    @Transactional
    public ResponseEntity<?> post(@RequestBody PostRequestBody body) {
        User user = UserMapper.INSTANCE.map(body);

        userService.save(user);

        return prepareResponse(UserMapper.INSTANCE.map(user), HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    @Transactional
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody PutRequestBody body) {
        User user = userService.getOne(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user = UserMapper.INSTANCE.map(body);

        userService.save(user);

        return prepareResponse(UserMapper.INSTANCE.map(user), HttpStatus.OK);
    }

    public static class PostRequestBody {
        public String firstName;
        public String lastName;
        public String username;
        public Gender gender;

        public PostRequestBody() {

        }
    }

    public static class PutRequestBody {
        public String firstName;
        public String lastName;
        public String username;
        public Gender gender;

        public PutRequestBody() {

        }
    }
}
