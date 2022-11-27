package com.haeju.uppgift_parking.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super("Car with ID " + id + " does not exists!");

    }
}
