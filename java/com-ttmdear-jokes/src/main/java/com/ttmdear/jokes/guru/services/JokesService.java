package com.ttmdear.jokes.guru.services;

import com.ttmdear.jokes.guru.model.JokeEntity;

import java.util.Set;

public interface JokesService {
    public Set<JokeEntity> findAll();
    public JokeEntity getRandomJoke();
}

