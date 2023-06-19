package com.doo.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = R2dbcAutoConfiguration.class)
public class SkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkeletonApplication.class, args);
	}

}
