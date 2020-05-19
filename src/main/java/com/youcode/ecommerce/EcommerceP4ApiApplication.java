package com.youcode.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceP4ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceP4ApiApplication.class, args);
	}

}
