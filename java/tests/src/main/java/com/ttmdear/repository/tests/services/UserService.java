package com.ttmdear.repository.tests.services;

import com.ttmdear.repository.tests.domain.User;

import java.util.Set;

public interface UserService {
    Set<User> find();

    User findById(String id);

    void active(User user);
}
