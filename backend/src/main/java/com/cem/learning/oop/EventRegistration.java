package com.cem.learning.oop;

public class EventRegistration {
    private final String eventId;
    private final String participantId;
    private final String status;

    public EventRegistration(String eventId, String participantId) {
        this(eventId, participantId, "REGISTERED");
    }

    // Constructor overloading: allows an explicit status when required.
    public EventRegistration(String eventId, String participantId, String status) {
        this.eventId = eventId;
        this.participantId = participantId;
        this.status = status;
    }

    public String getEventId() { return eventId; }
    public String getParticipantId() { return participantId; }
    public String getStatus() { return status; }
}
