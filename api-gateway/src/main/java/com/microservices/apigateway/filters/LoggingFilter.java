package com.microservices.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class LoggingFilter implements GlobalFilter {

    Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Request Coming.....");
        ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
        String url = request.getURI().toString();
        String countryName = request.getHeaders().getFirst("country");
        String ip = request.getRemoteAddress().toString();
        assert countryName != null;
        if (countryName.equals("US")) {
            try {
                throw new Exception("Country not allowed");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        logger.info("URL : " + request);
        return null;
    }
}
