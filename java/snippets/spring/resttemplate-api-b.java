/**
 * Przykład komunikacji z RestAPI z wykorzystaniem RestTemplate
 */

import lombok.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class BApi {
    private static final String REQ_FIELD_APIKEY = "apiKey";
    private static final String REQ_FIELD_PAGENUM = "pageNum";
    private static final String REQ_FIELD_PAGESIZE = "pageSize";
    private static final String REQ_FIELD_Q = "q";
    private static final String REQ_FIELD_REVERSEORDER = "reverseOrder";
    private static final String REQ_FIELD_SCOPE = "scope";
    private static final String REQ_FIELD_SORTFIELD = "sortField";

    private final RestTemplate restTemplate;
    private final BConfiguration tedConfiguration;

    public BApi(RestTemplateBuilder restTemplateBuilder, BConfiguration tedConfiguration) {
        restTemplate = restTemplateBuilder.build();

        this.tedConfiguration = tedConfiguration;
    }

    public void attachQueryParams(UriComponentsBuilder uriBuilder, AdsSearchParams params) {
        if (params.getApiKey() != null) {
            uriBuilder.queryParam(REQ_FIELD_APIKEY, params.getApiKey());
        }

        if (params.getPageNum() != null) {
            uriBuilder.queryParam(REQ_FIELD_PAGENUM, params.getPageNum());
        }

        if (params.getPageSize() != null) {
            uriBuilder.queryParam(REQ_FIELD_PAGESIZE, params.getPageSize());
        }

        if (params.getQ() != null) {
            uriBuilder.queryParam(REQ_FIELD_Q, params.getQ());
        }

        if (params.getReverseOrder() != null) {
            uriBuilder.queryParam(REQ_FIELD_REVERSEORDER, params.getReverseOrder());
        }

        if (params.getScope() != null) {
            uriBuilder.queryParam(REQ_FIELD_SCOPE, params.getScope());
        }

        if (params.getSortField() != null) {
            uriBuilder.queryParam(REQ_FIELD_SORTFIELD, params.getSortField());
        }

        if (params.getFields() != null && !params.getFields().isEmpty()) {
            params.getFields().forEach(field -> uriBuilder.queryParam("fields", field));
        }
    }

    private <T> HttpEntity<T> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new HttpEntity<>(null, httpHeaders);
    }

    public SearchResponseV2 getAdsSearch(AdsSearchParams params) {
        return restTemplate.exchange(prepareUrl(tedConfiguration.getApiUrlAdssSearch(), params), HttpMethod.GET,
            createHttpEntity(),
            SearchResponseV2.class).getBody();
    }

    @PostConstruct
    public void handlePostConstruct() {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(tedConfiguration.getApiBaseUrl());

        restTemplate.setUriTemplateHandler(uriBuilderFactory);
    }

    private String prepareUrl(String uri, AdsSearchParams params) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(uri);

        attachQueryParams(uriBuilder, params);

        return uriBuilder.build(false).toUriString();
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdsSearchParams {
        private String apiKey;
        private List<AdsField> fields;
        private Integer pageNum;
        private Integer pageSize;
        private String q;
        private Boolean reverseOrder;
        private Integer scope;
        private AdsSortField sortField;
    }
}
