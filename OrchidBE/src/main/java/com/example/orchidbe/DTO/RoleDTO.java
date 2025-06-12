package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RoleDTO {
    public static class RoleResponse{
        private Long id;
        private String name;
    }
    public static class RoleRequest{
        private String name;
    }
}
