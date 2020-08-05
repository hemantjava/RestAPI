package com.example.restapidevelopment.repo;

import com.example.restapidevelopment.dto.PersonDto;
import com.example.restapidevelopment.entity.Person;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Log4j2
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    @Transactional
    void findAllByAge() {
        List<Person> personList = personRepository.findAllByAge(30).get();
        assertNotNull(personList);
        log.info("personList :" + personList);
    }

    @Test
    @Transactional
    void deleteByAge() {
        personRepository.deleteById(30);
    }

    @Test
    void getListOfMail() {
        List<String> email = personRepository.getEmail();
        if (!CollectionUtils.isEmpty(email)) {
            log.info(email);
        }
    }

    @Test
    void findFirstName() {
        List<String> firstName = personRepository.findFirstName();
        if (!CollectionUtils.isEmpty(firstName)) {
            log.info(firstName);
        }
    }

    @Test
    void changeName() {
        personRepository.changeName(70, "Hemant");
        Optional<Person> byId = personRepository.findById(70);
        if (byId.isPresent())
            log.info(byId.get());
    }

    @Test
    void getPersonCount(){
        long personCount = personRepository.getPersonCount();
        log.info(personCount);
    }
    @Test
    void findByGenderAndAge(){
        List<Person> peopleList = personRepository.findByGenderAndAge("Male", 61);
        if(!CollectionUtils.isEmpty(peopleList))
           log.info(peopleList);
    }

    @Test
    void changeGender(){
        Integer male = personRepository.changeGender(54, "Male");
        log.info(male);
    }
    
    @Test
    void getPartialData(){
        Optional<List<PersonDto>> partialData = Optional.ofNullable(personRepository.getPartialData());
        if(partialData.isPresent())
            log.info(partialData.get());
    }
}