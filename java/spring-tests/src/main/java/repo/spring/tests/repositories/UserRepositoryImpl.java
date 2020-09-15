package repo.spring.tests.repositories;

import repo.spring.tests.domain.User;
import repo.spring.tests.domain.UserStatus;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Set<User> users = new HashSet<>();

    public UserRepositoryImpl() {
        users.add(new User("967a0a57-ba3e-4276-b2fe-1e340582bca2", "Paweł", "Kowalski", UserStatus.DEACTIVE));
        users.add(new User("46fb231f-c323-4332-a195-0bc9b93b91b9", "Justyna", "Iksińska", UserStatus.ACTIVE));
        users.add(new User("1950af9b-9c89-4d9b-8813-00f2ff8ee690", "Kasia", "Wrona", UserStatus.ACTIVE));
    }

    @Override
    public Set<User> findAll() {
        return users;
    }

    @Override
    public User findById(String id) {
        User userById = null;

        for (User user : users) {
            if (user.getId().equals(id)) {
                userById = user;
            }
        }

        return userById;
    }

    @Override
    public void save(User user) {
        if (Objects.isNull(user.getId())) {
            user.setId(UUID.randomUUID().toString());
        }

        users.add(user);
    }
}
