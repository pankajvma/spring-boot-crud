package com.springcrud.springbootcrud.repository;

import com.springcrud.springbootcrud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface People extends JpaRepository <Person, Integer> {
    List<Person> findByFirstName(String name);
}
