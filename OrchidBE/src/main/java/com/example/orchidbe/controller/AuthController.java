//package com.example.orchidbe.controller;
//
//import com.example.orchidbe.DTO.AccountDTO;
//import com.example.orchidbe.DTO.LoginDTO;
//import com.example.orchidbe.DTO.RegisterDTO;
//import com.example.orchidbe.auth.AuthenticationService;
//import com.example.orchidbe.auth.JwtService;
//import com.example.orchidbe.model.Account;
//import com.example.orchidbe.service.AccountService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//
//public class AuthController {
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private JwtService jwtUtil;
//
//    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> login(@RequestBody LoginDTO.LoginRequest loginRequest) {
//        try {
//            Account account = accountService.validateLogin(
//                    loginRequest.getEmail(),
//                    loginRequest.getPassword()
//            );
//
//            if (account == null) {
//                Map<String, String> response = new HashMap<>();
//                response.put("error", "Invalid credentials");
//                return ResponseEntity.badRequest().body(response);
//            }
//
//            String token = jwtUtil.generateToken(loginRequest.getEmail());
//            return ResponseEntity.ok(new LoginDTO.LoginResponse(token));
//        } catch (Exception e) {
//            Map<String, String> response = new HashMap<>();
//            response.put("error", e.getMessage());
//            return ResponseEntity.internalServerError().body(response);
//        }
//    }
//
//
//    @GetMapping
//    @Operation(
//            summary = "Get all accounts",
//            security = { @SecurityRequirement(name = "bearerAuth") }
//    )
//    @ApiResponse(responseCode = "200", description = "Successfully retrieved accounts")
//    @ApiResponse(responseCode = "401", description = "Unauthorized - Invalid or missing token")
//    public ResponseEntity<List<AccountDTO.AccountResponse>> getAllAccounts() {
//        List<AccountDTO.AccountResponse> accounts = accountService.getAllAccounts();
//        return ResponseEntity.ok(accounts);
//    }
//}