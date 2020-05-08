package com.ttmdear.repository.springtransactions.core.repositories;

import com.ttmdear.repository.springtransactions.core.domain.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRespository extends CrudRepository<UserRole, String> {
}
