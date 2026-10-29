package com.cem.auth;
import jakarta.validation.constraints.*;
public final class AuthDtos {
 private AuthDtos(){}
 public record RegisterRequest(@NotBlank @Size(max=120) String fullName,@NotBlank @Email @Size(max=180) String email,@NotBlank @Size(min=8,max=100) String password,@NotBlank String role){}
 public record LoginRequest(@NotBlank @Email String email,@NotBlank String password){}
 public record AuthResponse(String token,String fullName,String email,String role){}
 public record AccountResponse(Long id,String fullName,String email,String role){}
 public record CreateFacultyRequest(@NotBlank @Size(max=120) String fullName,@NotBlank @Email @Size(max=180) String email,@NotBlank @Size(min=8,max=100) String temporaryPassword){}
}
