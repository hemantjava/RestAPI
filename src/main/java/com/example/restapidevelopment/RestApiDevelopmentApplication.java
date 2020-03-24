package com.example.restapidevelopment;

import com.example.restapidevelopment.model.SortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiDevelopmentApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("bubbleSortAlgorithm")
	private SortAlgorithm sortAlgorithm;

	public static void main(String[] args) {
		SpringApplication.run(RestApiDevelopmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(sortAlgorithm);
	}
}
