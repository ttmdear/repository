package com.ttmdear.repository.tests.services;

import com.ttmdear.repository.tests.domain.User;

import java.util.Set;

public interface UserService {
    void active(User user);

    Set<User> find();

    User findById(String id);
}
