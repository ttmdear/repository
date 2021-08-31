package com.logi.autoconfigure;

import com.logi.Printer;
import com.logi.SimplePrinter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogiAutoconfigureOnClass {
    @Bean
    @ConditionalOnClass(name = "com.ttmdear.repository.springautoconfigure.UserService")
    public Printer printer() {
        return new SimplePrinter("LogiAutoconfigureOnClass");
    }
}
