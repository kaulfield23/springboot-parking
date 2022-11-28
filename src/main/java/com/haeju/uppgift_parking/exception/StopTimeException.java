package com.haeju.uppgift_parking.exception;

import java.time.LocalDateTime;

public class StopTimeException extends RuntimeException {
    public StopTimeException(LocalDateTime stopTime) {
        super("Following stop time: " + stopTime + " needs to be in future!");

    }
}
