package com.cem.dto;

import com.cem.model.Event;
import java.time.LocalDateTime;

public record EventResponse(
        Long id, String title, String category, String venue,
        LocalDateTime startsAt, int capacity, int registeredCount,
        String description, String status, String organizerName, String organizerEmail
) {
    public static EventResponse from(Event event) {
        return new EventResponse(event.getId(), event.getTitle(), event.getCategory(),
                event.getVenue(), event.getStartsAt(), event.getCapacity(),
                event.getRegisteredCount(), event.getDescription(), event.getStatus(), event.getOrganizerName(), event.getOrganizerEmail());
    }
}
