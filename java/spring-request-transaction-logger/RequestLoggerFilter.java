package com.dhl.mango.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Order(2)
public class RequestLoggerFilter extends OncePerRequestFilter {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, httpServletResponse);
        log.info("Request " + serializeRequest(requestWrapper));
    }

    private String serializeRequest(ContentCachingRequestWrapper request) throws IOException {
        RequestLog requestLog = new RequestLog();
        requestLog.setMethod(request.getMethod());
        requestLog.setUri(request.getRequestURI());
        requestLog.setQuery(request.getQueryString());

        HashMap<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            headers.put(header, request.getHeader(header));
        }

        requestLog.setHeaders(headers);

        String body = new String(request.getContentAsByteArray(), StandardCharsets.UTF_8);

        if (!body.isEmpty()) {
            String contentType = request.getHeader("Content-Type");
            if (contentType != null && contentType.equals("application/json")) {
                requestLog.setBody(MAPPER.readTree(body));
            } else {
                requestLog.setBody(body);
            }
        }

        return MAPPER.writeValueAsString(requestLog);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RequestLog {
        private String method;
        private String uri;
        private String query;
        private Map<String, String> headers;
        private Object body;
    }
}
