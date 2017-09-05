package com.applesoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Sipho on 04/09/2017.
 */

@SpringBootApplication(scanBasePackages = "true")
@ComponentScan(value = "com.applesoft")
@EnableAutoConfiguration
public class ApplesoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplesoftApplication.class, args);
	}
}
