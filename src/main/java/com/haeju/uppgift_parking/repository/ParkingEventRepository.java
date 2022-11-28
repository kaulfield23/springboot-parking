package com.haeju.uppgift_parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeju.uppgift_parking.model.ParkingEvent;

public interface ParkingEventRepository extends JpaRepository<ParkingEvent, Long> {

}
