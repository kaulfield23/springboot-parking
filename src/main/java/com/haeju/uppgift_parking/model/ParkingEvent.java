package com.haeju.uppgift_parking.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parking_evnet")
public class ParkingEvent {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Getter
    @Setter
    @ManyToOne
    private Person person;

    @Getter
    @Setter
    @ManyToOne
    private Car car;

    @Getter
    @Setter
    @ManyToOne
    private ParkingSpot parkingSpot;

    @Getter
    @Setter
    private LocalDateTime startTime;

    @Getter
    @Setter
    private LocalDateTime stopTime;

    @Getter
    @Setter
    Boolean status;
}
