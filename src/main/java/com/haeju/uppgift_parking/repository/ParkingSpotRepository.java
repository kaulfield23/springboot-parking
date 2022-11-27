package com.haeju.uppgift_parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeju.uppgift_parking.model.ParkingSpot;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

}
