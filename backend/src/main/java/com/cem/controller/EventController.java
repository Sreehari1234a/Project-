package com.cem.controller;
import com.cem.auth.Account; import com.cem.auth.AuthService;
import com.cem.dto.CreateEventRequest; import com.cem.dto.EventResponse; import com.cem.service.EventService;
import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/events") public class EventController {
 private final EventService events; private final AuthService auth;
 public EventController(EventService events,AuthService auth){this.events=events;this.auth=auth;}
 @GetMapping public List<EventResponse> list(){return events.findAll().stream().map(EventResponse::from).toList();}
 @GetMapping("/mine") public List<EventResponse> mine(@RequestHeader(value="Authorization",required=false) String h){Account a=auth.current(h,"ORGANIZER");return events.findByOrganizerEmail(a.getEmail()).stream().map(EventResponse::from).toList();}
 @GetMapping("/{id}") public EventResponse get(@PathVariable Long id){return EventResponse.from(events.findApprovedById(id));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public EventResponse create(@RequestHeader(value="Authorization",required=false) String h,@Valid @RequestBody CreateEventRequest r){Account a=auth.current(h,"ORGANIZER");CreateEventRequest secured=new CreateEventRequest(r.title(),r.category(),r.venue(),r.startsAt(),r.capacity(),r.description(),a.getFullName(),a.getEmail());return EventResponse.from(events.create(secured));}
}
