package com.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMain.class, args);
	}
}
