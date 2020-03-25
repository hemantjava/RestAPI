package com.example.restapidevelopment;

import com.example.restapidevelopment.model.SortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http://localhost:8384/swagger-ui.html   <i>swagger home page</i>
 */

@SpringBootApplication
public class RestApiDevelopmentApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(RestApiDevelopmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application up");
	}
}
