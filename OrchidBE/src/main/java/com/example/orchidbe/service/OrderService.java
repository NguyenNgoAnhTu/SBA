package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    // Define methods for order management
    OrderDTO.OrderResponse createOrder(OrderDTO.OrderRequest order);
    OrderDTO.OrderResponse getOrderById(Long id);
    OrderDTO.OrderResponse updateOrder(Long id,OrderDTO.OrderRequest order);
    void deleteOrder(Long id);
    List<OrderDTO.OrderResponse> getAllOrders();
}
