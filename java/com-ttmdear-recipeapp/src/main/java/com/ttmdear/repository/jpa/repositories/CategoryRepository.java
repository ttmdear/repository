package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
