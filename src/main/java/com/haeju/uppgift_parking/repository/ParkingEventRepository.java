package com.haeju.uppgift_parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeju.uppgift_parking.model.ParkingEvent;

public interface ParkingEventRepository extends JpaRepository<ParkingEvent, Long> {
    List<ParkingEvent> findAllByStatus(Boolean status);

    List<ParkingEvent> findAllByStatusAndCarId(Boolean status, Long id);

    List<ParkingEvent> findAllByStatusAndPersonId(Boolean status, Long personId);
}
