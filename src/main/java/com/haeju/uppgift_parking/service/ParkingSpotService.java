package com.haeju.uppgift_parking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeju.uppgift_parking.exception.ParkingSpotNotFoundException;
import com.haeju.uppgift_parking.model.ParkingSpot;
import com.haeju.uppgift_parking.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }

    public ParkingSpot addParkingSpot(ParkingSpot newParkingSpot) {
        return parkingSpotRepository.save(newParkingSpot);
    }

    public ParkingSpot findParkingSpotById(Long id) {
        return parkingSpotRepository.findById(id).orElseThrow(() -> new ParkingSpotNotFoundException(id));
    }
}
