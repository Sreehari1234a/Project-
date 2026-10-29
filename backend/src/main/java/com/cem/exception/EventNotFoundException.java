package com.cem.exception;

public class EventNotFoundException extends CemException {
    public EventNotFoundException(Long eventId) {
        super("Event with ID " + eventId + " was not found.");
    }
}
