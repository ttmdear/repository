import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
public class BZPApi {
    private final RestTemplate restTemplate;
    private final BZPConfiguration bzpConfiguration;

    public BZPApi(RestTemplateBuilder restTemplateBuilder, BZPConfiguration bzpConfiguration) {
        restTemplate = restTemplateBuilder.build();

        this.bzpConfiguration = bzpConfiguration;
    }

    private HttpEntity<PublishNoticeCommand> createHttpEntity(PublishNoticeCommand body) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new HttpEntity<>(body, httpHeaders);
    }

    @PostConstruct
    public void handlePostConstruct() {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(bzpConfiguration.getApiBaseUrl());

        restTemplate.setUriTemplateHandler(uriBuilderFactory);
    }

    public void postOnBoardPublishNoticeCommand(PublishNoticeCommand body) {
        restTemplate
            .exchange(bzpConfiguration.getApiUrlBoardPublishNoticeCommand(), HttpMethod.POST, createHttpEntity(body),
                String.class);
    }
}
