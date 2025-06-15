package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountDTO {
    @Data
    public static class AccountResponse {
        private String username;
        private String email;
        private String role;
    }
    @Data
    public static class AccountRequest {
        private String username;
        private String email;
        private String password;
        private String role;
    }

}
