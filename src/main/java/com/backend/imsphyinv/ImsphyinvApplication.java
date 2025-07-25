package com.backend.imsphyinv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//@SpringBootApplication (scanBasePackageClasses = phyinvController.class)
@SpringBootApplication
public class ImsphyinvApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ImsphyinvApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ImsphyinvApplication.class);
	}

}




