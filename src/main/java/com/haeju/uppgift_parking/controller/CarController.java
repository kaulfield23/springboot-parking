package com.haeju.uppgift_parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeju.uppgift_parking.model.Car;
import com.haeju.uppgift_parking.service.CarService;

@RestController
@RequestMapping("/api/car")

public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    Car addNewCar(@RequestBody Car newCar) {
        return carService.addNewCar(newCar);
    }

    @GetMapping("/{id}")
    Car getCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }
}
