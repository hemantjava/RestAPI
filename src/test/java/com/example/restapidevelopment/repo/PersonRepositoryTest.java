package com.example.restapidevelopment.repo;

import com.example.restapidevelopment.entity.Person;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Log4j2
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;


    @Test
    @Transactional
    void findAllByAge() {
      List<Person> personList =personRepository.findAllByAge(30).get();
        assertNotNull(personList);
        log.info("personList :"+personList);
    }
}