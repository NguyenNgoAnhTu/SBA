package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDetailDTO;
import com.example.orchidbe.model.OrderDetail;
import com.example.orchidbe.repository.OrderDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<OrderDetailDTO.OrderDetailResponse> getOrderDetailsByOrderId(Long orderId) {
        // Cần thêm: List<OrderDetail> findByOrder_OrderId(Long orderId); vào OrderDetailRepository
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrder_OrderId(orderId);
        return orderDetails.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDetailDTO.OrderDetailResponse getOrderDetailById(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Detail not found with id: " + id));
        return convertToDto(orderDetail);
    }

    private OrderDetailDTO.OrderDetailResponse convertToDto(OrderDetail detail) {
        OrderDetailDTO.OrderDetailResponse dto = new OrderDetailDTO.OrderDetailResponse();
        dto.setOrchidId(detail.getOrchid().getOrchidId());
        dto.setOrchidName(detail.getOrchid().getOrchidName());
        dto.setOrchidImageUrl(detail.getOrchid().getOrchidUrl());
        dto.setQuantity(detail.getQuantity());
        dto.setPrice(detail.getOrchid().getPrice());
        return dto;
    }

    // Các phương thức create, update, delete cho OrderDetail KHÔNG nên được triển khai ở đây
    // vì chúng phá vỡ tính toàn vẹn của một đơn hàng. Mọi thay đổi phải thông qua Order.
}