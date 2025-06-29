package com.example.orchidbe.DTO;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    // Dữ liệu client gửi lên để TẠO một đơn hàng mới
    @Data
    public static class CreateOrderRequest {
        private List<CartItemRequest> items;
        private String shippingAddress;
        private String note;
    }

    // Dữ liệu của một sản phẩm trong giỏ hàng
    @Data
    public static class CartItemRequest {
        private Long orchidId;
        private int quantity;
    }

    // Dữ liệu server gửi về để HIỂN THỊ một đơn hàng
    @Data
    public static class OrderResponse {
        private Long orderId;
        private LocalDateTime orderDate;
        private String orderStatus;
        private Double totalAmount;
        private String customerName; // Lấy từ Account liên kết
        private String shippingAddress;
        private String note;
        private List<OrderDetailDTO.OrderDetailResponse> orderDetails; // Trả về cả chi tiết sản phẩm
    }

    // Dữ liệu client gửi lên để CẬP NHẬT TRẠNG THÁI (dành cho admin)
    @Data
    public static class UpdateStatusRequest {
        private String status;
    }
}