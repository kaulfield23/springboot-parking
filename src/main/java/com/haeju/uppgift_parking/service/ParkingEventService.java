package com.haeju.uppgift_parking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeju.uppgift_parking.exception.ParkingEventNotFoundException;
import com.haeju.uppgift_parking.exception.StopTimeException;
import com.haeju.uppgift_parking.model.ParkingEvent;
import com.haeju.uppgift_parking.repository.ParkingEventRepository;

@Service
public class ParkingEventService {
    @Autowired
    private ParkingEventRepository parkingEventRepository;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private CarService carService;

    @Autowired
    private PersonService personService;

    public List<ParkingEvent> getAllParkingEvent() {
        return parkingEventRepository.findAll();
    }

    public ParkingEvent getParkingEventById(Long id) {
        return parkingEventRepository.findById(id).orElseThrow(() -> new ParkingEventNotFoundException(id));
    }

    public ParkingEvent createParkingEvent(ParkingEvent parkingEvent) {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime stopTime = parkingEvent.getStopTime();

        if (stopTime.isBefore(startTime)) {
            throw new StopTimeException(stopTime);
        }

    }
}
