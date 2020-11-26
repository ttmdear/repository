/**
 * Przykład konwertowania z obiektu na JSONA i odwrotnie.
 */

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MetadataConverter implements AttributeConverter<Metadata, String> {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String convertToDatabaseColumn(Metadata metadata) {
        try {
            return objectMapper.writeValueAsString(metadata);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Metadata convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Metadata.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
