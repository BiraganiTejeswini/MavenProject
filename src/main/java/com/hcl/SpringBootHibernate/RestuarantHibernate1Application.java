package com.hcl.SpringBootHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer; 
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RestuarantHibernate1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestuarantHibernate1Application.class, args);
	}
	@Override     protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {        
		return application.sources(RestuarantHibernate1Application.class);     }

}
