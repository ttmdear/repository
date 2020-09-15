package repo.spring.tests.services;

import repo.spring.tests.domain.User;

import java.util.Set;

public interface UserService {
    void active(User user);

    Set<User> find();

    User findById(String id);
}
