package com.example.orchidbe.controller;

import com.example.orchidbe.DTO.LoginDTO;
import com.example.orchidbe.DTO.RegisterDTO;
import com.example.orchidbe.auth.AuthenticationService;
import com.example.orchidbe.auth.JwtService;
import com.example.orchidbe.model.Account;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthController {
    JwtService jwtService;
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Account> register(@RequestBody RegisterDTO request) {
        Account account = authenticationService.signup(request);
        return ResponseEntity.ok(account);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginDTO.LoginResponse> login(@RequestBody LoginDTO.LoginRequest request) {
            Account account = authenticationService.login(request);
            String token = jwtService.generateToken(account);
        LoginDTO.LoginResponse response = new LoginDTO.LoginResponse();
        response.setToken(token);
        response.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(response);
    }
}