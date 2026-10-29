package com.cem.dto;
import com.cem.model.EventRegistration;
import java.time.LocalDateTime;
public record RegistrationResponse(Long id, Long eventId, String studentName, String email, String studentId, String status, LocalDateTime registeredAt) {
 public static RegistrationResponse from(EventRegistration r){return new RegistrationResponse(r.getId(),r.getEventId(),r.getStudentName(),r.getEmail(),r.getStudentId(),r.getStatus(),r.getRegisteredAt());}
}
