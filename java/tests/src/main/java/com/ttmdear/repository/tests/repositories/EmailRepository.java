package com.ttmdear.repository.tests.repositories;

import com.ttmdear.repository.tests.domain.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email, String> {

}
