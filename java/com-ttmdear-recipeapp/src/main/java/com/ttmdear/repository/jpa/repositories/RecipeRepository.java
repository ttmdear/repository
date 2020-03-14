package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.Phone;
import com.ttmdear.repository.jpa.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
