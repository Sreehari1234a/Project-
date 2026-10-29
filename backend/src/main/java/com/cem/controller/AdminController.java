package com.cem.controller;
import com.cem.auth.AuthService; import com.cem.dto.EventResponse; import com.cem.service.EventService;
import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/admin") public class AdminController {
 private final EventService events; private final AuthService auth;
 public AdminController(EventService events,AuthService auth){this.events=events;this.auth=auth;}
 @GetMapping("/events/all") public List<EventResponse> all(@RequestHeader(value="Authorization",required=false) String h){auth.current(h,"ADMIN","FACULTY");return events.findAllForAdmin().stream().map(EventResponse::from).toList();}
 @GetMapping("/events/pending") public List<EventResponse> pending(@RequestHeader(value="Authorization",required=false) String h){auth.current(h,"ADMIN","FACULTY");return events.findPending().stream().map(EventResponse::from).toList();}
 @PostMapping("/events/{id}/approve") public EventResponse approve(@RequestHeader(value="Authorization",required=false) String h,@PathVariable Long id){auth.current(h,"ADMIN","FACULTY");return EventResponse.from(events.approve(id));}
 @PostMapping("/events/{id}/reject") public EventResponse reject(@RequestHeader(value="Authorization",required=false) String h,@PathVariable Long id){auth.current(h,"ADMIN","FACULTY");return EventResponse.from(events.reject(id));}
}
