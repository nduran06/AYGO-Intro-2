package com.docker.intro.api.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
	
	@Value("${userWebApp.path}")
	private String userWebApp;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
       return builder.routes()
        		        	.route("intro", r -> r.path("/user/**").uri(userWebApp))
        		         	.build();
    }

}