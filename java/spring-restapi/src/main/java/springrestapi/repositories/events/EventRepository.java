package springrestapi.repositories.events;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import springrestapi.domain.events.Event;

public interface EventRepository extends ReactiveMongoRepository<Event, String> {
}
