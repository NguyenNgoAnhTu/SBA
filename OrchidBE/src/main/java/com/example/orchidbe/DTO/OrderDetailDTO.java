package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OrderDetailDTO {
    @Data
    public static class OrderDetailResponse {

        private Long orchidId;
        private String orchidName;
        private String orchidImageUrl;

        private Integer quantity;
        private Double price;
    }
}
