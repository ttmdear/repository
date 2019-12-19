package com.ttmdear.jokes.guru.config;

import com.ttmdear.jokes.guru.services.HelloWorldENGService;
import com.ttmdear.jokes.guru.services.HelloWorldPLService;
import com.ttmdear.jokes.guru.services.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeansConfiguration {

    @Bean
    @Primary
    @Profile({"default", "eng"})
    public HelloWorldService helloWorldENGNService() {
        return new HelloWorldENGService();
    }

    @Bean
    @Profile({"pl"})
    public HelloWorldService helloWorldPLService() {
        return new HelloWorldPLService();
    }
}
