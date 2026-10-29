package com.cem.service;

import com.cem.dto.CreateEventRequest;
import com.cem.exception.EventNotFoundException;
import com.cem.exception.InvalidEventException;
import com.cem.model.Event;
import com.cem.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository) { this.eventRepository = eventRepository; }

    @Transactional(readOnly = true)
    public List<Event> findAll() { return eventRepository.findByStatusOrderByStartsAtAsc("APPROVED"); }

    @Transactional(readOnly = true)
    public Event findApprovedById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        if (!"APPROVED".equals(event.getStatus())) throw new EventNotFoundException(id);
        return event;
    }

    @Transactional(readOnly = true)
    public List<Event> findPending() { return eventRepository.findByStatusOrderByStartsAtAsc("PENDING_APPROVAL"); }

    @Transactional(readOnly = true)
    public List<Event> findByOrganizerEmail(String email) { return eventRepository.findByOrganizerEmailIgnoreCaseOrderByStartsAtAsc(email.trim()); }

    @Transactional(readOnly = true)
    public List<Event> findAllForAdmin() { return eventRepository.findAllByOrderByStartsAtAsc(); }

    @Transactional
    public Event create(CreateEventRequest request) {
        if (request.capacity() < 1) throw new InvalidEventException("Event capacity must be at least 1.");
        Event event = new Event(request.title().trim(), request.category().trim(), request.venue().trim(), request.startsAt(), request.capacity(), request.description().trim());
        event.setStatus("PENDING_APPROVAL");
        event.setOrganizerName(request.organizerName() == null ? "" : request.organizerName().trim());
        event.setOrganizerEmail(request.organizerEmail() == null ? "" : request.organizerEmail().trim().toLowerCase());
        return eventRepository.save(event);
    }

    @Transactional
    public Event approve(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        event.setStatus("APPROVED"); return eventRepository.save(event);
    }

    @Transactional
    public Event reject(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        event.setStatus("REJECTED"); return eventRepository.save(event);
    }
}
