package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDTO.OrderDetailResponse createOrderDetail(OrderDetailDTO.OrderDetailRequest orderDetailRequest);
    OrderDetailDTO.OrderDetailResponse getOrderDetailById(String id);
    OrderDetailDTO.OrderDetailResponse getOrderDetail(String orderId);
    List<OrderDetailDTO.OrderDetailResponse> getAllOrderDetails();
    OrderDetailDTO.OrderDetailResponse updateOrderDetail(String id, OrderDetailDTO.OrderDetailRequest orderDetailRequest);
    void deleteOrderDetail(String id);
    List<OrderDetailDTO.OrderDetailResponse> getOrderDetailsByOrderId(String orderId);
}
