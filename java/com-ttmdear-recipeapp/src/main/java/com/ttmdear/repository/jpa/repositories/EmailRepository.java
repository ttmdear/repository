package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.Difficulty;
import com.ttmdear.repository.jpa.domain.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Long> {
}
