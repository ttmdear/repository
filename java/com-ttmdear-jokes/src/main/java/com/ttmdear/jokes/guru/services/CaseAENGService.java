package com.ttmdear.jokes.guru.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default", "eng"})
public class CaseAENGService implements CaseAService {
    @Override
    public String getMessage() {
        return "Message";
    }
}
