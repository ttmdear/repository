/**
 * Przykład konwertowania z obiektu na JSONA i odwrotnie.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

public class MetadataConverter implements AttributeConverter<Metadata, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

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
