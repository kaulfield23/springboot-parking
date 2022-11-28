package com.haeju.uppgift_parking.exception;

public class ParkingEventNotFoundException extends RuntimeException {
    public ParkingEventNotFoundException(Long id) {
        super("Parking Event with ID " + id + " does not exists!");

    }
}
