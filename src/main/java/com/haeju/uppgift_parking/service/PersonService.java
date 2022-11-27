package com.haeju.uppgift_parking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeju.uppgift_parking.exception.PersonNotFoundException;
import com.haeju.uppgift_parking.model.Car;
import com.haeju.uppgift_parking.model.Person;
import com.haeju.uppgift_parking.repository.CarRepository;
import com.haeju.uppgift_parking.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CarRepository carRepository;

    public Person addNewPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public List<Car> getPersonCars(Long id) {
        return carRepository.findByPersonId(id);
    }
}