package com.haeju.uppgift_parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeju.uppgift_parking.model.Car;
import com.haeju.uppgift_parking.model.Person;
import com.haeju.uppgift_parking.repository.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PersonService personService;

    public Car addNewCar(Car newCar) {
        Long personId = newCar.getPerson().getId();
        Person person = personService.getPersonById(personId);
        newCar.setPerson(person);

        return carRepository.save(newCar);
    }
}
