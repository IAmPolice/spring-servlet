package com.serlvet.exception;

public class CarNotFoundException extends Exception {
    public CarNotFoundException() {
        super("Fuel not found.");
    }

    public CarNotFoundException(String car) {
        super(String.format("The user car(%s) of fuel not found.", car));
    }
}
