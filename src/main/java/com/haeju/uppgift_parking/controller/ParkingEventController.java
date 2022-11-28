package com.haeju.uppgift_parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeju.uppgift_parking.model.ParkingEvent;
import com.haeju.uppgift_parking.service.ParkingEventService;

@RestController
@RequestMapping("/api/parkingevent")
public class ParkingEventController {
    @Autowired
    private ParkingEventService parkingEventService;

    @GetMapping
    List<ParkingEvent> getParkingEvent() {
        return parkingEventService.getAllParkingEvent();
    }

    @GetMapping("/{id}")
    ParkingEvent getEventById(@PathVariable Long id) {
        return parkingEventService.getParkingEventById(id);
    }

}
