package com.haeju.uppgift_parking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.haeju.uppgift_parking.exception.ParkingEventNotFoundException;
import com.haeju.uppgift_parking.exception.StopTimeException;
import com.haeju.uppgift_parking.model.Car;
import com.haeju.uppgift_parking.model.ParkingEvent;
import com.haeju.uppgift_parking.model.ParkingSpot;
import com.haeju.uppgift_parking.model.Person;
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

    public ParkingEvent addParkingEvent(ParkingEvent parkingEvent) {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime stopTime = parkingEvent.getStopTime();

        if (stopTime.isBefore(startTime)) {
            throw new StopTimeException(stopTime);
        }

        Long parkingSpotId = parkingEvent.getParkingSpot().getId();
        ParkingSpot parkingSpot = parkingSpotService.findParkingSpotById(parkingSpotId);
        parkingEvent.setParkingSpot(parkingSpot);

        Long personId = parkingEvent.getPerson().getId();
        Person person = personService.getPersonById(personId);
        parkingEvent.setPerson(person);

        Long carId = parkingEvent.getCar().getId();
        Car car = carService.findCarById(carId);
        parkingEvent.setCar(car);

        parkingEvent.setStartTime(startTime);
        parkingEvent.setStopTime(stopTime);
        parkingEvent.setStatus(true);

        return parkingEventRepository.save(parkingEvent);

    }

    public List<ParkingEvent> getParkingEventByStatus(Boolean status) {
        return parkingEventRepository.findAllByStatus(status);
    }

    public List<ParkingEvent> getParkingEventByStatusAndCarId(Boolean status, Long carId) {
        return parkingEventRepository.findAllByStatusAndCarId(status, carId);
    }

    public List<ParkingEvent> getParkingEventByStatusAndPersonId(Boolean active, Long personId) {
        return parkingEventRepository.findAllByStatusAndPersonId(active, personId);
    }

    public ParkingEvent updateParkingEventStopTimeById(Long id, LocalDateTime newStopTime) {
        LocalDateTime timeNow = LocalDateTime.now();
        ParkingEvent parkingEventToUpdate = parkingEventRepository.findById(id)
                .orElseThrow(() -> new ParkingEventNotFoundException(id));

        if (newStopTime.isBefore(timeNow)) {
            throw new StopTimeException(newStopTime);
        }
        parkingEventToUpdate.setStopTime(newStopTime);
        return parkingEventRepository.save(parkingEventToUpdate);
    }
}
