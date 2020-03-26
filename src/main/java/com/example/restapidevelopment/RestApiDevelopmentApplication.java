package com.example.restapidevelopment;

import com.example.restapidevelopment.config.DummyData;
import com.example.restapidevelopment.entity.Car;
import com.example.restapidevelopment.entity.Person;
import com.example.restapidevelopment.repo.CarRepository;
import com.example.restapidevelopment.repo.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * http://localhost:8384/swagger-ui.html   <i>swagger home page</i>
 */

@SpringBootApplication
@Log4j2
public class RestApiDevelopmentApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CarRepository carRepository;


	public static void main(String[] args) {
		SpringApplication.run(RestApiDevelopmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> personList  = DummyData.getPeople();
		List<Car> carList  = DummyData.getCars();
		personRepository.deleteAll();
		carRepository.deleteAll();
		List<Person> personList1  = personRepository.saveAll(personList);
		List<Car> carList1 =  carRepository.saveAll(carList);
				if(!personList1.isEmpty()){
			       log.info("List of people table is created");
				}else {
					log.info("List of people table is not created");
				}
		      if(!carList1.isEmpty()){
			log.info("List of car table is created");
		    }else {
			log.info("List of car table is not created");
		   }
	}
}
