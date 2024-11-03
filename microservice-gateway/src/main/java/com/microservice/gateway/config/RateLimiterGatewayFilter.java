package com.microservice.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiterGatewayFilter implements GatewayFilter, Ordered {

    private final KeyResolver keyResolver;
    private final ConcurrentHashMap<String, RateLimitInfo> rateLimiters = new ConcurrentHashMap<>();

    private static class RateLimitInfo {
        AtomicInteger requestCount = new AtomicInteger(0);
        long firstRequestTime = System.currentTimeMillis();
    }

    public RateLimiterGatewayFilter(KeyResolver keyResolver) {
        this.keyResolver = keyResolver;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return keyResolver.resolve(exchange).flatMap(key -> {
            RateLimitInfo rateLimitInfo = rateLimiters.computeIfAbsent(key, k -> new RateLimitInfo());

            long currentTime = System.currentTimeMillis();
            long timeSinceFirstRequest = currentTime - rateLimitInfo.firstRequestTime;

            if (timeSinceFirstRequest > 60000) {
                rateLimitInfo.requestCount.set(0);
                rateLimitInfo.firstRequestTime = currentTime;
            }

            int currentRequestCount = rateLimitInfo.requestCount.incrementAndGet();
            System.out.println("Key: " + key + ", Request Count: " + currentRequestCount);

            if (currentRequestCount > 20) {
                System.out.println("Rate limit exceeded for key: " + key);
                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        });
    }

    @Override
    public int getOrder() {
        return -1;
    }
}