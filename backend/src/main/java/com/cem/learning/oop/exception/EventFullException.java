package com.cem.learning.oop.exception;

public class EventFullException extends RegistrationException {
    public EventFullException(String eventId) {
        super("Event " + eventId + " has reached capacity.");
    }
}
