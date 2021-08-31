package com.logi.autoconfigure;

import com.logi.Printer;
import com.logi.SimplePrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogiAutoconfigureByName {

    @Bean("logiPrinter")
    public Printer printer() {
        return new SimplePrinter("LogiAutoconfigureByName");
    }
}
