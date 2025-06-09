package com.example.orchidbe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    public static class OrderResponse {
        private Long id;
        private String orderDate;
        private String status;
        private String customerName;
        private String customerEmail;
        private String shippingAddress;
    }

    public static class OrderRequest {
        private String orderDate;
        private String status;
        private String customerName;
        private String customerEmail;
        private String shippingAddress;
    }
}
