package com.haeju.uppgift_parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeju.uppgift_parking.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByPersonId(Long id);
}