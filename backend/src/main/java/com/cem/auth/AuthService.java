package com.cem.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Service
public class AuthService implements CommandLineRunner {
 private final AccountRepository accounts; private final AuthSessionRepository sessions;
 private final String adminEmail,adminPassword; private final SecureRandom random=new SecureRandom();
 public AuthService(AccountRepository accounts,AuthSessionRepository sessions,@Value("${cem.admin-email:principal@cem.local}") String adminEmail,@Value("${cem.admin-password:ChangeMe!2026}") String adminPassword){this.accounts=accounts;this.sessions=sessions;this.adminEmail=adminEmail;this.adminPassword=adminPassword;}
 @Override public void run(String... args){if(!accounts.existsByEmailIgnoreCase(adminEmail)){accounts.save(new Account("Principal / Campus Admin",adminEmail,"ADMIN",hash(adminPassword)));}}
 @Transactional public AuthDtos.AuthResponse register(AuthDtos.RegisterRequest r){String role=r.role().trim().toUpperCase();if(!role.equals("STUDENT")&&!role.equals("ORGANIZER"))throw new IllegalArgumentException("Public signup is available for students and organizers only.");String email=r.email().trim().toLowerCase();if(accounts.existsByEmailIgnoreCase(email))throw new IllegalArgumentException("An account with this email already exists.");Account a=accounts.save(new Account(r.fullName().trim(),email,role,hash(r.password())));return issue(a);}
 @Transactional public AuthDtos.AuthResponse login(AuthDtos.LoginRequest r){Account a=accounts.findByEmailIgnoreCase(r.email().trim()).orElseThrow(()->new IllegalArgumentException("Email or password is incorrect."));if(!verify(r.password(),a.getPasswordHash()))throw new IllegalArgumentException("Email or password is incorrect.");return issue(a);}
 @Transactional public AuthDtos.AuthResponse issue(Account a){byte[] bytes=new byte[32];random.nextBytes(bytes);String token=Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);sessions.save(new AuthSession(token,a.getEmail(),a.getRole(),LocalDateTime.now().plusDays(7)));return new AuthDtos.AuthResponse(token,a.getFullName(),a.getEmail(),a.getRole());}
 @Transactional public Account current(String authorization,String... roles){String token=extract(authorization);AuthSession s=sessions.findByToken(token).orElseThrow(()->new IllegalArgumentException("Your session is invalid. Please sign in again."));if(s.getExpiresAt().isBefore(LocalDateTime.now())){sessions.deleteByToken(token);throw new IllegalArgumentException("Your session expired. Please sign in again.");}Account a=accounts.findByEmailIgnoreCase(s.getEmail()).orElseThrow(()->new IllegalArgumentException("Account no longer exists."));if(roles.length>0){boolean ok=false;for(String role:roles)if(role.equals(a.getRole()))ok=true;if(!ok)throw new ForbiddenException("Your account does not have permission to perform this action.");}return a;}
 @Transactional public void logout(String authorization){String token=extract(authorization);sessions.deleteByToken(token);}
 @Transactional public AuthDtos.AccountResponse createFaculty(String authorization,AuthDtos.CreateFacultyRequest r){current(authorization,"ADMIN");String email=r.email().trim().toLowerCase();if(accounts.existsByEmailIgnoreCase(email))throw new IllegalArgumentException("An account with this email already exists.");Account a=accounts.save(new Account(r.fullName().trim(),email,"FACULTY",hash(r.temporaryPassword())));return new AuthDtos.AccountResponse(a.getId(),a.getFullName(),a.getEmail(),a.getRole());}
 public String extract(String auth){if(auth==null||!auth.startsWith("Bearer ")||auth.length()<10)throw new IllegalArgumentException("Please sign in to continue.");return auth.substring(7).trim();}
 private String hash(String password){try{byte[] salt=new byte[16];random.nextBytes(salt);PBEKeySpec spec=new PBEKeySpec(password.toCharArray(),salt,210000,256);byte[] out=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();return "pbkdf2$210000$"+Base64.getEncoder().encodeToString(salt)+"$"+Base64.getEncoder().encodeToString(out);}catch(Exception e){throw new IllegalStateException("Password hashing unavailable",e);}}
 private boolean verify(String password,String stored){try{String[] p=stored.split("\\$");if(p.length!=4||!p[0].equals("pbkdf2"))return false;byte[] salt=Base64.getDecoder().decode(p[2]);PBEKeySpec spec=new PBEKeySpec(password.toCharArray(),salt,Integer.parseInt(p[1]),256);byte[] actual=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();return MessageDigest.isEqual(actual,Base64.getDecoder().decode(p[3]));}catch(Exception e){return false;}}
 public static class ForbiddenException extends RuntimeException{public ForbiddenException(String m){super(m);}}
}
