package com.docker.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.docker.intro.controller", "com.docker.intro.service", "com.docker.intro.repository"})
public class IntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroApplication.class, args);
	}

}
