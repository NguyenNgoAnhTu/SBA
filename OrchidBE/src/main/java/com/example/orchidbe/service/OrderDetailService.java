package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDTO.OrderDetailResponse createOrderDetail(OrderDetailDTO.OrderDetailRequest orderDetailRequest);
    OrderDetailDTO.OrderDetailResponse getOrderDetailById(Long id);
    OrderDetailDTO.OrderDetailResponse getOrderDetail(Long orderId);
    List<OrderDetailDTO.OrderDetailResponse> getAllOrderDetails();
    OrderDetailDTO.OrderDetailResponse updateOrderDetail(Long id, OrderDetailDTO.OrderDetailRequest orderDetailRequest);
    void deleteOrderDetail(Long id);
    List<OrderDetailDTO.OrderDetailResponse> getOrderDetailsByOrderId(Long orderId);
}
