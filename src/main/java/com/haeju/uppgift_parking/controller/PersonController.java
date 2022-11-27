package com.haeju.uppgift_parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeju.uppgift_parking.model.Car;
import com.haeju.uppgift_parking.model.Person;
import com.haeju.uppgift_parking.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    Person addNewPerson(@RequestBody Person newPerson) {
        return personService.addNewPerson(newPerson);
    }

    @GetMapping
    List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/{id}/cars")
    List<Car> getPersonCars(@PathVariable Long id) {
        return personService.getPersonCars(id);
    }

}
