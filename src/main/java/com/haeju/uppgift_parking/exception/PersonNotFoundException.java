package com.haeju.uppgift_parking.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Person with ID " + id + " does not exists!");
    }
}
