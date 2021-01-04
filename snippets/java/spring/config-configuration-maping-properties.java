/**
 * Przykład mapowania plików właściwości na klasę
 */

generator:
  types:
    ogl_o_kon:
      versions:
        - 1.0.0
    ogl_o_konc:
      versions:
        - 1.0.0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "generator")
@Data
public class GeneratorConfig {
    @Getter
    @Setter
    private Map<TypeEnum, TypeConfig> types = new HashMap<>();

    public GeneratorConfig() {
    }

    @PostConstruct
    public void postContruct() {
        types.forEach((type, typeConfig) -> {
            if (typeConfig.getVersions() == null || typeConfig.getVersions().isEmpty()) {
                throw new RuntimeException(String.format("Please set at least one version for type '%s'.", type));
            }
        });
    }

    @Data
    public static class TypeConfig {
        private String version;
        private List<String> versions = new ArrayList<>();
    }
}
