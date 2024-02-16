package com.repo.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.time.Duration;
import java.util.function.Function;

public class GetUserService {

    private Cache<String, User> cache;

    public GetUserService() {
        cache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(Duration.ofSeconds(30))
                .refreshAfterWrite(Duration.ofSeconds(30))
                .build(key -> null);
    }

    public User get(String userId) {
        return cache.get(userId, key -> {
            System.out.println("init cache for " + key);
            return getUserInner(key);
        });
    }

    private User getUserInner(String userId) {
        return new User(userId, "First name " + userId, "Last name " + userId);
    }
}
