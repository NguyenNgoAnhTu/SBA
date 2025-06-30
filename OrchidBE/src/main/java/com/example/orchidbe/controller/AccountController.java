package com.example.orchidbe.controller;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.DTO.LoginDTO;
import com.example.orchidbe.DTO.RegisterDTO;
import com.example.orchidbe.auth.JwtService;
import com.example.orchidbe.model.Account;
import com.example.orchidbe.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/accounts")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtService jwtUtil;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginDTO.LoginRequest loginRequest) {
        try {
            Account account = accountService.validateLogin(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()
            );

            if (account == null) {
                Map<String, String> response = new HashMap<>();
                response.put("error", "Invalid credentials");
                return ResponseEntity.badRequest().body(response);
            }

            String token = jwtUtil.generateToken(loginRequest.getEmail());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", account.getAccountName());
            response.put("email", account.getEmail());
            response.put("role" , account.getRole().getRoleName());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }


    @GetMapping
    @Operation(
            summary = "Get all accounts",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved accounts")
    @ApiResponse(responseCode = "401", description = "Unauthorized - Invalid or missing token")
    public ResponseEntity<List<AccountDTO.AccountResponse>> getAllAccounts() {
        List<AccountDTO.AccountResponse> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAccount(@RequestBody RegisterDTO accountRequest) {
        try {
            AccountDTO.AccountResponse createdAccount = accountService.signup(accountRequest);
            System.out.println("Created account: " + createdAccount);
            return ResponseEntity.status(201).body(createdAccount);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAccountById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(accountService.getAccount(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        try {
            accountService.deleteAccount(id);
            return ResponseEntity.ok("Account with id " + id + " deleted successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateAccount(@PathVariable Long id, @Valid @RequestBody AccountDTO.AccountUpdateRequest request) {
        try {
            return ResponseEntity.ok(accountService.updateAccount(id, request));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
