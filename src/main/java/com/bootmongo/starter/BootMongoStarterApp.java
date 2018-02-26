package com.bootmongo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.bootmongo.starter")
public class BootMongoStarterApp {
	public static void main(String[] args) {
		SpringApplication.run(BootMongoStarterApp.class, args);
	}
}