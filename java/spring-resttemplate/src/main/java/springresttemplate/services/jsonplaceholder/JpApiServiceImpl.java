package springresttemplate.services.jsonplaceholder;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import springresttemplate.services.jsonplaceholder.dto.UserDto;

@Service
public class JpApiServiceImpl implements JpApiService {
    private final RestTemplate restTemplate;
    private final String jpApiUrl;

    public JpApiServiceImpl(RestTemplate restTemplate, @Value("${jpapi.url}") String jpApiUrl) {
        this.restTemplate = restTemplate;

        this.jpApiUrl = jpApiUrl;
    }

    @Override
    public UserDto[] getUsers() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(jpApiUrl);

        // uriComponentsBuilder.queryParam("limit", 10);

        // restTemplate.patchForObject();
        // restTemplate.postForEntity()
        // Jest taki generyczny element JsonNode jsonNode

        return restTemplate.getForEntity(uriComponentsBuilder.toUriString(), UserDto[].class).getBody();
    }
}
