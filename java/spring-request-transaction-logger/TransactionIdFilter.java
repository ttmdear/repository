package com.dhl.mango.logger;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.UUID.randomUUID;

@Slf4j
@Component
@Order(1)
public class TransactionIdFilter extends OncePerRequestFilter {
    public static final String TRANSACTION_ID_KEY = "transactionID";
    public static final String TRANSACTION_ID_HEADER = "X-Transaction-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        String transactionID = randomUUID().toString();
        MDC.put(TRANSACTION_ID_KEY, transactionID);
        httpServletResponse.setHeader(TRANSACTION_ID_HEADER, transactionID);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
