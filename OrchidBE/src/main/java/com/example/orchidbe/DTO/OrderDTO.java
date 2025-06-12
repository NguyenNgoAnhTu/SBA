package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class OrderDTO {
    @Data
    public static class OrderResponse {
        private Long id;
        private String orderDate;
        private String status;
        private String customerName;
        private String customerEmail;
        private String shippingAddress;
    }
    @Data
    public static class OrderRequest {
        private String orderDate;
        private String status;
        private String customerName;
        private String customerEmail;
        private String shippingAddress;
    }
}
