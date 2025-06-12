package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CategoryDTO {
    public static class CategoryResponse {
        private Long id;
        private String name;
        private String description;
    }
    public static class CategoryRequest {
        private String name;
        private String description;
    }
}
