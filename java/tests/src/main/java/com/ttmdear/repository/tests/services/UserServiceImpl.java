package com.ttmdear.repository.tests.services;

import com.ttmdear.repository.tests.domain.User;
import com.ttmdear.repository.tests.domain.UserStatus;
import com.ttmdear.repository.tests.repositories.UserRepository;
import com.ttmdear.repository.tests.services.UserService;
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
