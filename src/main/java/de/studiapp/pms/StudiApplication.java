package de.studiapp.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 
 * @author AH/DH
 * aufgebohrtes  springboot.main
 */


@SpringBootApplication
public class StudiApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudiApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StudiApplication.class, args);
	}

}