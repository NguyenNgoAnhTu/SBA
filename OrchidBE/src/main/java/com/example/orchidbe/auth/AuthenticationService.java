package com.example.orchidbe.auth;

import com.example.orchidbe.DTO.LoginDTO;
import com.example.orchidbe.DTO.RegisterDTO;
import com.example.orchidbe.model.Account;
import com.example.orchidbe.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public Account signup(RegisterDTO register) {
        Account account =  Account.builder()
                .accountName(register.getFullName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .build();

        return accountRepository.save(account);
    }
    public Account login(LoginDTO.LoginRequest loginRequest)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        return accountRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + loginRequest.getEmail()));
    }

    public List<Account> allUsers() {
        List<Account> account = new ArrayList<>();
         accountRepository.findAll().forEach(u -> account.add(u));
         return account;
    }
}
