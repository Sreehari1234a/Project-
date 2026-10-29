package com.cem.auth;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="cem_sessions", indexes=@Index(columnList="token"))
public class AuthSession {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=100,unique=true) private String token;
 @Column(nullable=false,length=180) private String email;
 @Column(nullable=false,length=30) private String role;
 @Column(nullable=false) private LocalDateTime expiresAt;
 protected AuthSession(){}
 public AuthSession(String token,String email,String role,LocalDateTime expiresAt){this.token=token;this.email=email;this.role=role;this.expiresAt=expiresAt;}
 public String getToken(){return token;} public String getEmail(){return email;} public String getRole(){return role;} public LocalDateTime getExpiresAt(){return expiresAt;}
}
