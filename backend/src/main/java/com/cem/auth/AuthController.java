package com.cem.auth;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final AuthService auth; private final AccountRepository accounts;
 public AuthController(AuthService auth,AccountRepository accounts){this.auth=auth;this.accounts=accounts;}
 @PostMapping("/register") @ResponseStatus(HttpStatus.CREATED) public AuthDtos.AuthResponse register(@Valid @RequestBody AuthDtos.RegisterRequest r){return auth.register(r);}
 @PostMapping("/login") public AuthDtos.AuthResponse login(@Valid @RequestBody AuthDtos.LoginRequest r){return auth.login(r);}
 @GetMapping("/me") public AuthDtos.AccountResponse me(@RequestHeader(value="Authorization",required=false) String h){Account a=auth.current(h);return new AuthDtos.AccountResponse(a.getId(),a.getFullName(),a.getEmail(),a.getRole());}
 @PostMapping("/logout") public Map<String,String> logout(@RequestHeader(value="Authorization",required=false) String h){auth.logout(h);return Map.of("message","Signed out.");}
 @PostMapping("/faculty") @ResponseStatus(HttpStatus.CREATED) public AuthDtos.AccountResponse createFaculty(@RequestHeader(value="Authorization",required=false) String h,@Valid @RequestBody AuthDtos.CreateFacultyRequest r){return auth.createFaculty(h,r);}
}
