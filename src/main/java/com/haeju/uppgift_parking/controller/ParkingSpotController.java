package com.haeju.uppgift_parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeju.uppgift_parking.model.ParkingSpot;
import com.haeju.uppgift_parking.service.ParkingSpotService;

@RestController
@RequestMapping("/api/parkingspot")
public class ParkingSpotController {
    @Autowired
    private ParkingSpotService parkingSpotService;

    @GetMapping
    List<ParkingSpot> getParkingSpots() {
        return parkingSpotService.getAllParkingSpots();
    }

    @PostMapping
    ParkingSpot newParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        return parkingSpotService.addParkingSpot(parkingSpot);
    }

    @GetMapping("/{id}")
    ParkingSpot getParkingSpotById(@PathVariable Long id) {
        return parkingSpotService.findParkingSpotById(id);
    }
}
