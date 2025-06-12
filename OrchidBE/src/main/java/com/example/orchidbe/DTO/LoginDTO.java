package com.example.orchidbe.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LoginDTO {
    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class LoginResponse {
        private String token;
    }
}
