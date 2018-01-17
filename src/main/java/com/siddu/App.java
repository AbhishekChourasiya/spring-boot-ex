package com.siddu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.siddu")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}