package com.example.orchidbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name="price", nullable = false)
    private double price;
    @Column(name="quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="orchid_id", nullable = false)
    private Orchid orchid;

}
