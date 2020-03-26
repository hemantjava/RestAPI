package com.example.restapidevelopment.controller;

import com.example.restapidevelopment.entity.Person;
import com.example.restapidevelopment.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonJPAController {

    @Autowired
    private PersonRepository personRepository;
    // http://localhost:8384/person/getPersonList
    @GetMapping("/getPersonList")
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> personList = personRepository.findAll();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    // http://localhost:8384/person/getPersonList/limit/22
    @GetMapping("/getPersonList/limit/{limit}")
    public ResponseEntity<List<Person>> getPersonList(@PathVariable int limit) {
        List<Person> personList = personRepository.findAll().stream().limit(limit).collect(Collectors.toList());
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }
    // http://localhost:8384/person/findById/20
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent())
            return new ResponseEntity<>(personOptional.get(), HttpStatus.OK);
        return new ResponseEntity<>(id+"resource not available", HttpStatus.NOT_FOUND);

    }

    // http://localhost:8384/person/deleteById/20
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
           if(personRepository.existsById(id)) {
               personRepository.deleteById(id);
               return new ResponseEntity<>(id + ": id person deleted", HttpStatus.OK);
           }
        return new ResponseEntity<>(id + ": id not present", HttpStatus.NOT_FOUND);
    }

    // http://localhost:8384/person/create
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Person person) {
       Person person1 = personRepository.saveAndFlush(person);
       if(personRepository.existsById(person1.getId()))
        return new ResponseEntity<>("Id: "+person1.getId()+ ": new present created", HttpStatus.CREATED);
        return new ResponseEntity<>("Id: "+person1.getId()+ ": new present not created", HttpStatus.BAD_REQUEST);
    }

    // http://localhost:8384/person/update
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Person person) {
        Person person1 = personRepository.save(person);
        return new ResponseEntity<>(person1+ ": new present created", HttpStatus.CREATED);
    }

}
