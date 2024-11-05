package com.docker.intro.api.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
       return builder.routes()
        		        	.route("intro", r -> r.path("/user/**").uri("http://172.16.0.110:8090/"))
        		         	.build();
    }

}