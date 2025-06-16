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
    public OrderDetailDTO.OrderDetailResponse getOrderDetailById(Long id) {
        return null;
    }

    @Override
    public OrderDetailDTO.OrderDetailResponse getOrderDetail(Long orderId) {
        return null;
    }

    @Override
    public List<OrderDetailDTO.OrderDetailResponse> getAllOrderDetails() {
        return List.of();
    }

    @Override
    public OrderDetailDTO.OrderDetailResponse updateOrderDetail(Long id, OrderDetailDTO.OrderDetailRequest orderDetailRequest) {
        return null;
    }

    @Override
    public void deleteOrderDetail(Long id) {

    }

    @Override
    public List<OrderDetailDTO.OrderDetailResponse> getOrderDetailsByOrderId(Long orderId) {
        return List.of();
    }
}
