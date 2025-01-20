package com.sachith.server;

import com.sachith.server.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class BookMeServerSpringBootMavenScnApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMeServerSpringBootMavenScnApplication.class, args);
	}

}
