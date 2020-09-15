package repo.spring.tests.repositories;

import repo.spring.tests.domain.User;

import java.util.Set;

public interface UserRepository {
    Set<User> findAll();

    User findById(String id);

    void save(User user);
}
