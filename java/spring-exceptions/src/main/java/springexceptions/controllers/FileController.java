package springexceptions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springexceptions.services.FileRepository;
import springexceptions.services.UserRepository;

@Controller
public class FileController extends BaseController {
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    public FileController(FileRepository fileRepository, UserRepository userRepository) {
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/files/{userId}/{fileId}", method = RequestMethod.GET)
    public String get(@PathVariable String userId, @PathVariable String fileId) {
        return fileRepository.find(userRepository.findById(userId), fileId);
    }
}
