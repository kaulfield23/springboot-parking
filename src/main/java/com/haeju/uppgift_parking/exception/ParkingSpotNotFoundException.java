package com.haeju.uppgift_parking.exception;

public class ParkingSpotNotFoundException extends RuntimeException {
    public ParkingSpotNotFoundException(Long id) {
        super("Parking spot with ID " + id + " does not exists!");

    }
}
