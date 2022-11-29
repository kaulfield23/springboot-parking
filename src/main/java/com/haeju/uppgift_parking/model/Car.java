package com.haeju.uppgift_parking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;

@Entity
@RequestMapping("/api/car")
public class Car {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Getter
    @Setter
    String car_number;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
