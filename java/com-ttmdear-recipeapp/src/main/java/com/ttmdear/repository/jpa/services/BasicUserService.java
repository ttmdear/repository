package com.ttmdear.repository.jpa.services;

import com.ttmdear.repository.jpa.domain.User;
import com.ttmdear.repository.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;

@Service
public class BasicUserService implements UserService {
    private final UserRepository userRepository;

    public BasicUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }


    @Override
    public User getUser() {
        return userRepository.findAll().iterator().next();
    }
}
