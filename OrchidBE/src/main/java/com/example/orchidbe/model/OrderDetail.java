package com.example.orchidbe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

// Không cần @Document vì có thể được embed vào Order
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Field("quantity")
    private int quantity;

    @Field("unit_price")
    private double unitPrice;

    @Field("subtotal")
    private double subtotal;

    @DBRef
    private Orchid orchid;
}