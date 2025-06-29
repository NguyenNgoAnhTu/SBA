package com.example.orchidbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "orderStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name="shipping_address")
    private String shippingAddress;

    @Column(name="note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails;

    public enum OrderStatus {
        PENDING,     // Chờ xác nhận
        PROCESSING,  // Đang xử lý
        SHIPPED,     // Đã giao hàng
        COMPLETED,   // Hoàn thành
        CANCELLED    // Đã hủy
    }
}