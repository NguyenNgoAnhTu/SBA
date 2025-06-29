package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDTO;
import com.example.orchidbe.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public OrderDTO.OrderResponse createOrder(OrderDTO.OrderRequest order) {
        return null;
    }

    @Override
    public OrderDTO.OrderResponse getOrderById(String id) {
        return null;
    }

    @Override
    public OrderDTO.OrderResponse updateOrder(String id, OrderDTO.OrderRequest order) {
        return null;
    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public List<OrderDTO.OrderResponse> getAllOrders() {
        return List.of();
    }
}
