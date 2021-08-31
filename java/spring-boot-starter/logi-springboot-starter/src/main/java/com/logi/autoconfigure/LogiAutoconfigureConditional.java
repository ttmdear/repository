package com.logi.autoconfigure;

import com.logi.Printer;
import com.logi.SimplePrinter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class LogiAutoconfigureConditional {

    @Bean
    @ConditionalOnMissingBean(Printer.class)
    public Printer printer() {
        return new SimplePrinter("LogiAutoconfigureConditional");
    }
}
