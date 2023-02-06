package com.springcrud.springbootcrud.service;

import com.springcrud.springbootcrud.entity.Person;
import com.springcrud.springbootcrud.repository.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    @Autowired
    private People repository;

    // post methods
    public Person savePerson(Person person){
        return repository.save(person);
    }

    public List<Person> savePersons(List<Person> person){
        return repository.saveAll(person);
    }

    // get methods
    public Person getPersonByID(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Person> getPersons(){
        return repository.findAll();
    }

    public List<Person> getPersonByName(String name){
        return repository.findByFirstName(name);
    }

    // delete method
    public  String deletePersonByID(int id){
        repository.deleteById(id);
        return "Removed id: "+ id;
    }

    // put method
    public Person updatePerson(Person person){
        Person existingPerson = getPersonByID(person.getId());
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setAge(person.getAge());

        return repository.save(existingPerson);
    }
}