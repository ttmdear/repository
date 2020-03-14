package com.ttmdear.repository.jpa.repositories;

import com.ttmdear.repository.jpa.domain.Ingredient;
import com.ttmdear.repository.jpa.domain.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {
}
