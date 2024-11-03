package com.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import com.microservice.gateway.config.RateLimiterConfig;
import com.microservice.gateway.config.RateLimiterGatewayFilter;

@SpringBootApplication
public class MicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder, RateLimiterConfig rateLimiterConfig) {
		RateLimiterGatewayFilter rateLimiterFilter = new RateLimiterGatewayFilter(rateLimiterConfig.ipKeyResolver());

		return builder.routes()
				.route("msvc-crops", r -> r.path("/api/v1/crops/**")
						.filters(f -> f.filter(rateLimiterFilter))
						.uri("lb://MICROSERVICE-CROPS"))
				.route("msvc-sowings", r -> r.path("/api/v1/sowings/**")
						.filters(f -> f.filter(rateLimiterFilter))
						.uri("lb://MICROSERVICE-SOWINGS"))
				.route("msvc-profiles", r -> r.path("/api/v1/profiles/**")
						.filters(f -> f.filter(rateLimiterFilter))
						.uri("lb://MICROSERVICE-PROFILES"))
				.route("msvc-foroum", r -> r.path("/api/v1/forum/**")
						.filters(f -> f.filter(rateLimiterFilter))
						.uri("lb://MICROSERVICE-FOROUM"))
				.build();
	}
}