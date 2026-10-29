package com.cem.auth;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="cem_accounts", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Account {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false,length=120) private String fullName;
    @Column(nullable=false,length=180,unique=true) private String email;
    @Column(nullable=false,length=30) private String role;
    @Column(nullable=false,length=500) private String passwordHash;
    @Column(nullable=false) private LocalDateTime createdAt=LocalDateTime.now();
    protected Account() {}
    public Account(String fullName,String email,String role,String passwordHash){this.fullName=fullName;this.email=email.toLowerCase().trim();this.role=role;this.passwordHash=passwordHash;}
    public Long getId(){return id;} public String getFullName(){return fullName;} public String getEmail(){return email;} public String getRole(){return role;} public String getPasswordHash(){return passwordHash;} public LocalDateTime getCreatedAt(){return createdAt;}
    public void setRole(String role){this.role=role;}
}
