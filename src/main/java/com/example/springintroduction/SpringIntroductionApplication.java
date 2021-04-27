package com.example.springintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-context.xml")
public class SpringIntroductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroductionApplication.class, args);
	}

}
