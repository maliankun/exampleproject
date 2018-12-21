package com.inspur.exampleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.delivery.request"})
@EntityScan("com.inspur.exampleproject.entity")
@EnableJpaRepositories("com.inspur.exampleproject.repository")
public class ExampleprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleprojectApplication.class, args);
	}
}
