package springrestapi.domain.events;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    private String id;

    private String message;
}
