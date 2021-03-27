package spring5aop.services;

import spring5aop.domain.User;

public interface UserService {
    User findById(String id);
}
