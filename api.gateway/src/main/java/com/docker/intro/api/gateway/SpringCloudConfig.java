package com.docker.intro.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class SpringCloudConfig {

	private static Logger logger = LoggerFactory.getLogger(SpringCloudConfig.class);

	@Value("${userWebApp.path}")
	private String userWebApp;

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route("intro", r -> r.path("/**").uri(userWebApp))
				.route("static-content", r -> r.path("/**").filters(f -> f.preserveHostHeader()
						// Remove any automatic handling of static resources
						.setResponseHeader("Cache-Control", "no-cache")
						// Log the forwarded URL (for debugging)
						.modifyRequestBody(String.class, String.class, (exchange, s) -> {
							logger.info("Forwarding to: " + exchange.getRequest().getURI());
							return Mono.just(s);
						})).uri(userWebApp))
				.build();
	}

}