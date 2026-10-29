package com.cem.learning.oop;

import com.cem.learning.oop.exception.EventFullException;
import com.cem.learning.oop.exception.RegistrationException;

public class RegistrationService {
    public String dashboardFor(PlatformUser user) {
        // Polymorphism: the method called depends on the actual subclass object.
        return user.getDisplayName() + " — " + user.dashboardLabel();
    }

    public EventRegistration register(PlatformUser user, String eventId, int seatsAvailable)
            throws RegistrationException {
        if (!(user instanceof Student)) {
            throw new RegistrationException("Only students can register for an event.");
        }
        if (seatsAvailable <= 0) {
            throw new EventFullException(eventId);
        }
        return new EventRegistration(eventId, user.getUserId());
    }

    // Method overloading: a default-seat convenience method.
    public EventRegistration register(PlatformUser user, String eventId)
            throws RegistrationException {
        return register(user, eventId, 1);
    }
}
