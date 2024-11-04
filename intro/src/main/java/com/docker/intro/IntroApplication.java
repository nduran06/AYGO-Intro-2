package com.docker.intro;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.docker.intro.controller", "com.docker.intro.service", "com.docker.intro.repository" })
public class IntroApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(IntroApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
		app.run(args);
	}

	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 8090;
	}

}
