package com.ttmdear.petclinic.data.services.map;

import com.ttmdear.petclinic.data.model.BaseEntity;

import java.util.*;
import java.util.function.Predicate;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<T>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (Objects.isNull(object)) {
            throw new RuntimeException("Object can not be null.");
        }

        if (Objects.isNull(object.getId())) {
            object.setId(generateNewId());
        }

        map.put(object.getId(), object);

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(new Predicate<Map.Entry<Long, T>>() {
            @Override
            public boolean test(Map.Entry<Long, T> entry) {
                return entry.getValue().equals(object);
            }
        });
    }

    private Long generateNewId() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {

            nextId = 1L;
        }

        return nextId;
    }
}
