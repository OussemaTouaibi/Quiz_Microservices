package com.esprit.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy
@ComponentScan("com.esprit.quiz")
@EnableJpaRepositories("com.esprit.quiz.repository")
@EntityScan(basePackages = {"com.esprit.quiz.entity"})
public class QuizApplication {
	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}	
}
