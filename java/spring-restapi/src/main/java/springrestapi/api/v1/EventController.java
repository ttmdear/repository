package springrestapi.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springrestapi.domain.events.Event;
import springrestapi.repositories.events.EventRepository;

@RestController
@RequestMapping(BaseController.BASE_URL)
public class EventController extends BaseController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public Flux<Event> getList() {
        return eventRepository.findAll();
    }

    @GetMapping("/events/{id}")
    public Mono<Event> getById(@PathVariable String id) {
        return eventRepository.findById(id);
    }
}
