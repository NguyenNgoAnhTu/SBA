package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OrchidDTO {
    @Data
    public static class OrchidResponse {
        private Long id;
        private String name;
        private String description;
        private String imageUrl;
        private String categoryName;
        private boolean isNatural;
        private Double price;
    }
    @Data
    public static class OrchidRequest {
        private String name;
        private String description;
        private String imageUrl;
        private Long categoryId;
        private Double price;
        private boolean isNatural;
    }
}
