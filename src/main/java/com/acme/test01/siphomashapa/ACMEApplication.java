package com.acme.test01.siphomashapa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Sipho on 10/09/2017.
 */

@SpringBootApplication(scanBasePackages = "true")
@ComponentScan(value = "com.acme.test01")
@EnableAutoConfiguration
public class ACMEApplication {

	public static void main(String[] args) {
		SpringApplication.run(ACMEApplication.class, args);
	}
}
