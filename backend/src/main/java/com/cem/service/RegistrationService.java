package com.cem.service;

import com.cem.dto.CreateRegistrationRequest;
import com.cem.exception.EventNotFoundException;
import com.cem.model.Event;
import com.cem.model.EventRegistration;
import com.cem.repository.EventRepository;
import com.cem.repository.RegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class RegistrationService {
 private final EventRepository events; private final RegistrationRepository registrations;
 public RegistrationService(EventRepository events, RegistrationRepository registrations){this.events=events;this.registrations=registrations;}
 @Transactional public EventRegistration register(Long eventId, CreateRegistrationRequest request){
  Event event=events.findById(eventId).orElseThrow(()->new EventNotFoundException(eventId));
  if(!"APPROVED".equals(event.getStatus())) throw new IllegalArgumentException("This event is not open for registration.");
  String email=request.email().trim().toLowerCase();
  if(registrations.existsByEventIdAndEmailAndStatus(eventId,email,"REGISTERED")) throw new IllegalArgumentException("This email is already registered for the event.");
  long count=registrations.countByEventIdAndStatus(eventId,"REGISTERED");
  if(count>=event.getCapacity()) throw new IllegalArgumentException("Sorry, this event is full.");
  EventRegistration saved=registrations.findByEventIdAndEmailIgnoreCase(eventId,email).map(existing->{existing.setStatus("REGISTERED");existing.setRegisteredAt(LocalDateTime.now());existing.setStudentId(request.studentId()==null?"":request.studentId().trim());return registrations.save(existing);}).orElseGet(()->registrations.save(new EventRegistration(eventId,request.studentName().trim(),email,request.studentId()==null?"":request.studentId().trim())));
  event.setRegisteredCount((int)count+1); events.save(event); return saved;
 }
 @Transactional(readOnly=true) public List<EventRegistration> byEmail(String email){return registrations.findByEmailIgnoreCaseOrderByRegisteredAtDesc(email.trim());}
 @Transactional public void cancel(Long id,String email){
  EventRegistration r=registrations.findById(id).orElseThrow(()->new IllegalArgumentException("Registration not found."));
  if(!r.getEmail().equalsIgnoreCase(email.trim())) throw new IllegalArgumentException("Use the email address associated with this registration.");
  if(!"REGISTERED".equals(r.getStatus())) throw new IllegalArgumentException("This registration is already cancelled.");
  r.setStatus("CANCELLED"); registrations.save(r);
  events.findById(r.getEventId()).ifPresent(e->{e.setRegisteredCount(Math.max(0,e.getRegisteredCount()-1));events.save(e);});
 }
 @Transactional(readOnly=true) public List<EventRegistration> forEvent(Long eventId){return registrations.findByEventIdOrderByRegisteredAtAsc(eventId);}
}
