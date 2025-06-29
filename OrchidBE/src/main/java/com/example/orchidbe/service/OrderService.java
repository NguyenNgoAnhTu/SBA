package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    // Define methods for order management
    OrderDTO.OrderResponse createOrder(OrderDTO.CreateOrderRequest request);
    OrderDTO.OrderResponse getOrderById(Long id);
    List<OrderDTO.OrderResponse> getAllOrders();
    OrderDTO.OrderResponse updateOrderStatus(Long orderId, OrderDTO.UpdateStatusRequest request);
    void deleteOrder(Long id);
    List<OrderDTO.OrderResponse> getOrdersByCurrentUser();

}
