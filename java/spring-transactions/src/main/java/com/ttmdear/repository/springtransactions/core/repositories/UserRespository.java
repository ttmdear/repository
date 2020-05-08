package com.ttmdear.repository.springtransactions.core.repositories;

import com.ttmdear.repository.springtransactions.core.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<User, String> {
}
