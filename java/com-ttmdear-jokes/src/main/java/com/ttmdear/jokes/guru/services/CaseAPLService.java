package com.ttmdear.jokes.guru.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"pl"})
public class CaseAPLService implements CaseAService {
    @Override
    public String getMessage() {
        return "Wiadomość";
    }
}
