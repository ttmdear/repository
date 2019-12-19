package com.ttmdear.jokes.patterns.strategy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final TaxCounterContext taxCounterContext;

    public Main(TaxCounterContext taxCounterContext) {
        this.taxCounterContext = taxCounterContext;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-- Patterns strategy --");
        // Wykorzystanie algorytmu wstrzykniętego przez profil.
        System.out.println(taxCounterContext.count(10));

        System.out.println("Change algorithm");

        taxCounterContext.setTaxCounter(new PLTaxCounter());

        // Zmiana algorytmu
        System.out.println(taxCounterContext.count(10));
    }
}
