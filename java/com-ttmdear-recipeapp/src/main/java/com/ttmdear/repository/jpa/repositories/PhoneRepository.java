package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.Notes;
import com.ttmdear.repository.jpa.domain.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
