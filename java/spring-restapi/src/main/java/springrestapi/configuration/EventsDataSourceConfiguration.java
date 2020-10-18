package springrestapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"springrestapi.repositories.events"})
public class EventsDataSourceConfiguration {

}
