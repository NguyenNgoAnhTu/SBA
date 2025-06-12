package com.example.orchidbe.DTO;


import lombok.Data;

public class LoginDTO {
    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }
    @Data
    public static class LoginResponse {
        private String token;
        private long expiresIn;
    }
}
