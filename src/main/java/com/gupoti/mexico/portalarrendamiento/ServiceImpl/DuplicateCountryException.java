package com.gupoti.mexico.portalarrendamiento.ServiceImpl;

public class DuplicateCountryException extends RuntimeException {
    public DuplicateCountryException(String message) {
        super(message);
    }
}
