package spring5aop.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import spring5aop.domain.User;
import spring5aop.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("d24d4a33-12a0-4c4d-81f0-00172bacb6e2", "John", "Lastkowski"));
        userList.add(new User("ad750c40-f696-4dad-a561-8b985f0e87df", "Jessy", "Kowalska"));
        userList.add(new User("6205e2c4-0c83-4b52-8dae-d5ba079bfbde", "Monika", "Pisłowska"));
    }

    @Override
    public User findById(String id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }
}
