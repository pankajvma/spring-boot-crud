package com.springcrud.springbootcrud.controller;

import com.springcrud.springbootcrud.entity.Person;
import com.springcrud.springbootcrud.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PeopleService service;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return service.savePerson(person);
    }

    @PostMapping("/addPersons")
    public List<Person> addPersons(@RequestBody List<Person> persons){
        return service.savePersons(persons);
    }


    @GetMapping("/personID/{id}")
    public Person findPerson(@PathVariable int id){ //if we have to pass any inpit as a part of url then we should use path variable. Here "id" is the variable being passed in the url
        return service.getPersonByID(id);
    }


    @GetMapping("/personName/{name}")
    public List<Person> findPersonByName(@PathVariable String name){
        return service.getPersonByName(name);
    }

    @GetMapping("/persons")
    public List<Person> findAllPersons(){
        return service.getPersons();
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person){
        return service.updatePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id){
        return service.deletePersonByID(id);
    }
}
