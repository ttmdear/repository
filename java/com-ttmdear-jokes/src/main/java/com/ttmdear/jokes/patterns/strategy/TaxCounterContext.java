package com.ttmdear.jokes.patterns.strategy;

import org.springframework.stereotype.Component;

@Component
public class TaxCounterContext {

    private TaxCounter taxCounter;

    public TaxCounterContext(TaxCounter taxCounter) {
        this.taxCounter = taxCounter;
    }

    public double count(double value) {
        if (taxCounter == null) {
            throw new RuntimeException("Tax counter can not be null");
        }

        return taxCounter.count(value);
    }

    public TaxCounter getTaxCounter() {
        return taxCounter;
    }

    public void setTaxCounter(TaxCounter taxCounter) {
        this.taxCounter = taxCounter;
    }
}
