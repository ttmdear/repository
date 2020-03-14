package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.Recipe;
import com.ttmdear.repository.jpa.domain.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
