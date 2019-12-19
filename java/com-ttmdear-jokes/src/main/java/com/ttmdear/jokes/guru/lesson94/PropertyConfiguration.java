package com.ttmdear.jokes.guru.lesson94;

import com.ttmdear.jokes.guru.lesson94.services.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:lesson94.properties")
public class PropertyConfiguration {

    @Value("${lesson94.username}")
    private String dataSourceUsername;

    @Value("${lesson94.password}")
    private String dataSourcePassword;

    @Value("${lesson94.url}")
    private String dataSourceUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        System.out.println(String.format("dataSource: %s, %s, %s", dataSourceUsername, dataSourcePassword, dataSourceUrl));
        FakeDataSource fakeDataSource = new FakeDataSource();

        fakeDataSource.setUsername(dataSourceUsername);
        fakeDataSource.setPassword(dataSourcePassword);
        fakeDataSource.setUrl(dataSourceUrl);

        return fakeDataSource;
    }
}
