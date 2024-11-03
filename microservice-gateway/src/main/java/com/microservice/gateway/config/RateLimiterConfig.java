package com.microservice.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class RateLimiterConfig {

    private final ConcurrentHashMap<String, RateLimitInfo> rateLimiters = new ConcurrentHashMap<>();

    private static class RateLimitInfo {
        AtomicInteger requestCount = new AtomicInteger(0);
        long firstRequestTime = System.currentTimeMillis();
    }

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            String ipAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            RateLimitInfo rateLimitInfo = rateLimiters.computeIfAbsent(ipAddress, k -> new RateLimitInfo());

            long currentTime = System.currentTimeMillis();
            long timeSinceFirstRequest = currentTime - rateLimitInfo.firstRequestTime;

            if (timeSinceFirstRequest > 60000) {
                rateLimitInfo.requestCount.set(0);
                rateLimitInfo.firstRequestTime = currentTime;
            }

            int currentRequestCount = rateLimitInfo.requestCount.incrementAndGet();
            System.out.println("IP Address: " + ipAddress + ", Request Count: " + currentRequestCount);

            if (currentRequestCount > 20) {
                System.out.println("Rate limit exceeded for IP: " + ipAddress);
                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                return Mono.empty();
            }

            return Mono.just(ipAddress);
        };
    }
}