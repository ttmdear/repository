package com.ttmdear.repository.springtransactions.core.repositories;

import com.ttmdear.repository.springtransactions.core.domain.Group;
import com.ttmdear.repository.springtransactions.core.domain.UserGroup;
import com.ttmdear.repository.springtransactions.core.domain.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import static com.ttmdear.repository.springtransactions.core.domain.UserGroup.*;

@Repository
public interface UserGroupRespository extends CrudRepository<UserGroup, UserGroupId> {
}
