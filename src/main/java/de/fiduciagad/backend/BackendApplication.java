package de.fiduciagad.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	public static final String ACCOUNTS_SERVICE_URL
			= "http://ACCOUNTS-SERVICE";
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);



	}

}
