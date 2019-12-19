package com.ttmdear.jokes.patterns.strategy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("pl")
public class PLTaxCounter implements TaxCounter {
    @Override
    public double count(double value) {
        return 0.23 * value;
    }
}
