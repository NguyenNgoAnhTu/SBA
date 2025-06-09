package com.example.orchidbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name="order_id", nullable = false, unique = true)
    private Long orderId;
    @Column(name="order_date", nullable = false)
    private String orderDate;
    @Column(name="orderStatus", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;
    @Column(name="total_amount", nullable = false)
    private String totalAmount;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    enum OrderStatus {
        PENDING,
        PROCESSING,
        CANCELLED,
        COMPLETED,
    }
}
