package com.ttmdear.repository.jpa.services;

import com.ttmdear.repository.jpa.domain.User;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface UserService {
    Set<User> getUsers();

    User getUser();
}

