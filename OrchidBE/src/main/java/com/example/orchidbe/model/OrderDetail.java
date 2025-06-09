package com.example.orchidbe.model;

import jakarta.persistence.*;

@Entity
@Table(name="order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name="price", nullable = false)
    private float price;
    @Column(name="quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="orchid_id", nullable = false)
    private Orchid orchid;

}
