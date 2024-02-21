package com.rex.democrud.service.exceptions;

public class DriverNotFoundException extends Exception{

    public DriverNotFoundException() {
        super();
    }

    public DriverNotFoundException(String message) {
        super(message);
    }
}
