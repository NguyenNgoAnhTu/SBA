package com.example.orchidbe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {
    @Id
    private String orderId;

    @Field("order_date")
    private LocalDateTime orderDate;

    @Field("total_amount")
    private double totalAmount;

    @Field("status")
    private String status;


    // Nếu có OrderDetail như một embedded document
}