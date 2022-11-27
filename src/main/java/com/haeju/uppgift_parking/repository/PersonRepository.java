package com.haeju.uppgift_parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeju.uppgift_parking.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
