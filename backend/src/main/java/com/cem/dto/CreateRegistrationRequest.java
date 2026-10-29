package com.cem.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
public record CreateRegistrationRequest(@Size(max=120) String studentName,@Email @Size(max=180) String email,@Size(max=40) String studentId) {}
