package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrderDetailDTO {
    public static class OrderDetailResponse {
        private Long id;
        private Long orderId;
        private Long orchidId;
        private Integer quantity;
        private Double price;
    }
    public static class OrderDetailRequest {
        private Long orderId;
        private Long orchidId;
        private Integer quantity;
        private Double price;
    }
}
