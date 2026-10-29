package com.cem.controller;
import com.cem.auth.Account; import com.cem.auth.AuthService; import com.cem.dto.CreateRegistrationRequest; import com.cem.dto.RegistrationResponse; import com.cem.service.RegistrationService;
import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.List; import java.util.Map;
@RestController @RequestMapping("/api") public class RegistrationController {
 private final RegistrationService service; private final AuthService auth;
 public RegistrationController(RegistrationService service,AuthService auth){this.service=service;this.auth=auth;}
 @PostMapping("/events/{eventId}/registrations") @ResponseStatus(HttpStatus.CREATED) public RegistrationResponse register(@RequestHeader(value="Authorization",required=false) String h,@PathVariable Long eventId,@Valid @RequestBody CreateRegistrationRequest r){Account a=auth.current(h,"STUDENT");CreateRegistrationRequest secured=new CreateRegistrationRequest(a.getFullName(),a.getEmail(),r.studentId());return RegistrationResponse.from(service.register(eventId,secured));}
 @GetMapping("/registrations") public List<RegistrationResponse> mine(@RequestHeader(value="Authorization",required=false) String h){Account a=auth.current(h,"STUDENT");return service.byEmail(a.getEmail()).stream().map(RegistrationResponse::from).toList();}
 @DeleteMapping("/registrations/{id}") public Map<String,String> cancel(@RequestHeader(value="Authorization",required=false) String h,@PathVariable Long id){Account a=auth.current(h,"STUDENT");service.cancel(id,a.getEmail());return Map.of("message","Registration cancelled.");}
 @GetMapping("/admin/events/{eventId}/registrations") public List<RegistrationResponse> attendees(@RequestHeader(value="Authorization",required=false) String h,@PathVariable Long eventId){auth.current(h,"ADMIN","FACULTY");return service.forEvent(eventId).stream().map(RegistrationResponse::from).toList();}
}
