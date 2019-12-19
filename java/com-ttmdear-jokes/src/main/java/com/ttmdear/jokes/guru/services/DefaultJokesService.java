package com.ttmdear.jokes.guru.services;

import com.ttmdear.jokes.guru.model.JokeEntity;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DefaultJokesService implements JokesService {
    private final ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();

    @Override
    public Set<JokeEntity> findAll() {
        return null;
    }

    @Override
    public JokeEntity getRandomJoke() {
        JokeEntity jokeEntity = new JokeEntity();

        jokeEntity.setContent(chuckNorrisQuotes.getRandomQuote());

        return jokeEntity;
    }
}
