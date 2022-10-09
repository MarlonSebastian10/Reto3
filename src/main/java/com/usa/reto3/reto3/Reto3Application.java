package com.usa.reto3.reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"com.usa.reto3.reto3"})
@EntityScan("com.usa.reto3.reto3.model")
@EnableJpaRepositories("com.usa.reto3.reto3.Repository")
public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}
}
