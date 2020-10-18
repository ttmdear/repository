package springrestapi.services;

import org.springframework.stereotype.Service;
import springrestapi.domain.user.core.User;
import springrestapi.repositories.users.UserRepository;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, String> implements UserService {
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }
}
