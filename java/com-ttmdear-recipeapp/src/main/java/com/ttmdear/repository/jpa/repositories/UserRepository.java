package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.UnitOfMeasure;
import com.ttmdear.repository.jpa.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByFirstName(String firstName);
}
