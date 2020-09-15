package repo.spring.tests.services;

import repo.spring.tests.domain.User;
import repo.spring.tests.domain.UserStatus;
import repo.spring.tests.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void active(User user) {
        user.setStatus(UserStatus.ACTIVE);

        userRepository.save(user);
    }

    public Set<User> find() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

}
