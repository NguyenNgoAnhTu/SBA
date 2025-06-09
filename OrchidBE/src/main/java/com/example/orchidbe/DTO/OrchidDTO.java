package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrchidDTO {
    public static class OrchidResponse {
        private Long id;
        private String name;
        private String description;
        private String imageUrl;
        private String categoryName;
    }

    public static class OrchidRequest {
        private String name;
        private String description;
        private String imageUrl;
        private Long categoryId;
    }
}
