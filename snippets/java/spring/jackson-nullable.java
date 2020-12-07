/**
 * W przypadku gdy w OpenApi stosowany jest Nullable moduł to w konfiguracji
 * Springa musimy dodać ten moduł tak aby to pole było poprawnie serializowane.
 */
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {
    @Bean
    public JsonNullableModule jsonNullableModule() {
        return new JsonNullableModule();
    }
}
