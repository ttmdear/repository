package springexceptions.services;

import org.springframework.stereotype.Repository;
import springexceptions.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Repository
public class UserRepository {
    public static final String STATIC_USER_ID = "efcb3c59-cc41-467a-9ddd-5e823bd3734e";

    public List<User> getAll() {
        List<User> users = new ArrayList<User>(){{
            add(new User(STATIC_USER_ID, "Jan", "Kowalski"));
            add(new User("Jan", "Kowalski"));
            add(new User("Krystian", "Iksiński"));
            add(new User("Monika", "Wrona"));
        }};

        return users;
    }

    public User findById(String id) {
        return getAll().stream().filter((user) -> {
            return user.getId().equals(id);
        }).findFirst().orElseGet(new Supplier<User>() {
            @Override
            public User get() {
                return null;
            }
        });
    }
}
