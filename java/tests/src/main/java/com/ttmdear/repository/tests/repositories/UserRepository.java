package com.ttmdear.repository.tests.repositories;

import com.ttmdear.repository.tests.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface UserRepository {
    Set<User> findAll();

    User findById(String id);

    void save(User user);
}
