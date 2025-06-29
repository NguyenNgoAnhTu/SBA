package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    // Define methods for order management
    OrderDTO.OrderResponse createOrder(OrderDTO.OrderRequest order);
    OrderDTO.OrderResponse getOrderById(String id);
    OrderDTO.OrderResponse updateOrder(String id,OrderDTO.OrderRequest order);
    void deleteOrder(String id);
    List<OrderDTO.OrderResponse> getAllOrders();
}
