package com.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("msvc-crops", r -> r.path("/api/v1/crops/**")
						.uri("lb://MICROSERVICE-CROPS"))
				.route("msvc-sowings", r -> r.path("/api/v1/sowings/**")
						.uri("lb://MICROSERVICE-SOWINGS"))
				.route("msvc-profiles", r -> r.path("/api/v1/profiles/**")
						.uri("lb://MICROSERVICE-PROFILES"))
				.build();
	}
}
