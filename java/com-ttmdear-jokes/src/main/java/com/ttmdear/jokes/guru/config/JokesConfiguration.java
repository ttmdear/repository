package com.ttmdear.jokes.guru.config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

// @Configuration
public class JokesConfiguration {

    // @Bean
    public ChuckNorrisQuotes chuckNorrisQuotes() {
        return new ChuckNorrisQuotes();
    }
}
