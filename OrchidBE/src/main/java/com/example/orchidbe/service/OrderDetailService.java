package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDetailDTO;
import com.example.orchidbe.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
     List<OrderDetailDTO.OrderDetailResponse> getOrderDetailsByOrderId(Long orderId);
    OrderDetailDTO.OrderDetailResponse getOrderDetailById(Long id);


    }
