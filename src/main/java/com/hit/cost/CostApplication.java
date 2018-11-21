package com.hit.cost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(
		//exclude = {DataSourceAutoConfiguration.class}
		)
@EnableJpaRepositories("com.hit.cost.jpa")
/**
 * 启用定时任务
 */
@EnableScheduling
public class CostApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostApplication.class, args);
	}
}
