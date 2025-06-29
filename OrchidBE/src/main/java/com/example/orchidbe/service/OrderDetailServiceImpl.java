package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements  OrderDetailService{
    @Override
    public OrderDetailDTO.OrderDetailResponse createOrderDetail(OrderDetailDTO.OrderDetailRequest orderDetailRequest) {
        return null;
    }

    @Override
    public OrderDetailDTO.OrderDetailResponse getOrderDetailById(String id) {
        return null;
    }

    @Override
    public OrderDetailDTO.OrderDetailResponse getOrderDetail(String orderId) {
        return null;
    }

    @Override
    public List<OrderDetailDTO.OrderDetailResponse> getAllOrderDetails() {
        return List.of();
    }

    @Override
    public OrderDetailDTO.OrderDetailResponse updateOrderDetail(String id, OrderDetailDTO.OrderDetailRequest orderDetailRequest) {
        return null;
    }

    @Override
    public void deleteOrderDetail(String id) {

    }

    @Override
    public List<OrderDetailDTO.OrderDetailResponse> getOrderDetailsByOrderId(String orderId) {
        return List.of();
    }
}
