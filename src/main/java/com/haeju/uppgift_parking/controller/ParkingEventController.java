package com.haeju.uppgift_parking.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haeju.uppgift_parking.model.ParkingEvent;
import com.haeju.uppgift_parking.service.ParkingEventService;

@RestController
@RequestMapping("/api/parkingevent")
public class ParkingEventController {
    @Autowired
    private ParkingEventService parkingEventService;

    @GetMapping
    List<ParkingEvent> getParkingEvents() {
        return parkingEventService.getAllParkingEvent();
    }

    @GetMapping("/{id}")
    ParkingEvent getEventById(@PathVariable Long id) {
        return parkingEventService.getParkingEventById(id);
    }

    @PostMapping
    ParkingEvent addNewParkngEvent(@RequestBody ParkingEvent parkingEvent) {
        ParkingEvent newParkingEvent = parkingEventService.addParkingEvent(parkingEvent);

        if (newParkingEvent.getId() == null) {
            return null;
        }

        return newParkingEvent;
    }

    @GetMapping("/status")
    List<ParkingEvent> getParkingEventByStatus(@RequestParam Boolean active) {
        return parkingEventService.getParkingEventByStatus(active);
    }

    @GetMapping("/status/car/{id}")
    List<ParkingEvent> getParkingEventByStatusAndCarId(@RequestParam Boolean active, @PathVariable Long id) {
        return parkingEventService.getParkingEventByStatusAndCarId(active, id);
    }

    @GetMapping("/status/person/{id}")
    List<ParkingEvent> getParkingEventByStatusAndPersonId(@RequestParam Boolean active, @PathVariable Long id) {
        return parkingEventService.getParkingEventByStatusAndPersonId(active, id);
    }

    @PatchMapping("/{id}")
    ParkingEvent patchParkingStopTime(@PathVariable Long id, @RequestBody ParkingEvent parkingEvent) {
        LocalDateTime newStopTime = parkingEvent.getStopTime();

        return parkingEventService.updateParkingEventStopTimeById(id, newStopTime);
    }
}
