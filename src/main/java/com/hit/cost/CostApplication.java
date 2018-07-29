package com.hit.cost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		//exclude = {DataSourceAutoConfiguration.class}
		)
@EnableJpaRepositories("com.hit.cost.jpa")
public class CostApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostApplication.class, args);
	}
}
