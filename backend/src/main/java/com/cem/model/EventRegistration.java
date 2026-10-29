package com.cem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_registrations", uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "email"}))
public class EventRegistration {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name="event_id", nullable=false) private Long eventId;
    @Column(nullable=false, length=120) private String studentName;
    @Column(nullable=false, length=180) private String email;
    @Column(length=40) private String studentId;
    @Column(nullable=false, length=24) private String status = "REGISTERED";
    @Column(nullable=false) private LocalDateTime registeredAt = LocalDateTime.now();
    protected EventRegistration() {}
    public EventRegistration(Long eventId, String studentName, String email, String studentId) { this.eventId=eventId; this.studentName=studentName; this.email=email.toLowerCase().trim(); this.studentId=studentId; }
    public Long getId(){return id;} public Long getEventId(){return eventId;} public String getStudentName(){return studentName;} public String getEmail(){return email;} public String getStudentId(){return studentId;} public String getStatus(){return status;} public LocalDateTime getRegisteredAt(){return registeredAt;}
    public void setStatus(String status){this.status=status;} public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;} public void setStudentId(String studentId){this.studentId=studentId;}
}
