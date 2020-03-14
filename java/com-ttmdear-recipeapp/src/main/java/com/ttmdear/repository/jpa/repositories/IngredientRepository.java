package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.Email;
import com.ttmdear.repository.jpa.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
