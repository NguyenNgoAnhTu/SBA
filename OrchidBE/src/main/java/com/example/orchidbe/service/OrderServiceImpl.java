package com.example.orchidbe.service;

import com.example.orchidbe.DTO.OrderDTO;
import com.example.orchidbe.DTO.OrderDetailDTO;
import com.example.orchidbe.model.Account;
import com.example.orchidbe.model.Order;
import com.example.orchidbe.model.Orchid;
import com.example.orchidbe.model.OrderDetail;
import com.example.orchidbe.repository.AccountRepository;
import com.example.orchidbe.repository.OrderDetailRepository;
import com.example.orchidbe.repository.OrderRepository;
import com.example.orchidbe.repository.OrchidRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final OrchidRepository orchidRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public OrderDTO.OrderResponse createOrder(OrderDTO.CreateOrderRequest request) {
        // 1. Lấy thông tin người dùng đang đăng nhập
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Account currentUser = accountRepository.findByEmail(userEmail)
                .orElseThrow(() -> new EntityNotFoundException("Authenticated user not found. Please login again."));

        // 2. Tạo đối tượng Order trong bộ nhớ (chưa lưu)
        Order newOrder = new Order();
        newOrder.setAccount(currentUser);
        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setOrderStatus(Order.OrderStatus.PENDING);
        newOrder.setShippingAddress(request.getShippingAddress());
        newOrder.setNote(request.getNote());

        List<OrderDetail> details = new ArrayList<>();
        double totalAmount = 0.0;

        // 3. Xử lý các chi tiết đơn hàng và tính tổng tiền
        for (OrderDTO.CartItemRequest itemRequest : request.getItems()) {
            Orchid orchid = orchidRepository.findById(itemRequest.getOrchidId())
                    .orElseThrow(() -> new EntityNotFoundException("Orchid not found with id: " + itemRequest.getOrchidId()));

            totalAmount += orchid.getPrice() * itemRequest.getQuantity();

            OrderDetail detail = new OrderDetail();
            detail.setOrder(newOrder); // Gán vào đối tượng Order trong bộ nhớ
            detail.setOrchid(orchid);
            detail.setQuantity(itemRequest.getQuantity());
            detail.setPrice(orchid.getPrice());
            details.add(detail);
        }

        // 4. Gán tổng tiền và danh sách chi tiết vào đối tượng Order
        newOrder.setTotalAmount(totalAmount);
        newOrder.setOrderDetails(details);

        // 5. LƯU MỘT LẦN DUY NHẤT:
        // Nhờ có `CascadeType.ALL` trong Entity Order, khi lưu newOrder,
        // các OrderDetail trong danh sách `details` cũng sẽ tự động được lưu theo.
        Order savedOrder = orderRepository.save(newOrder);

        return convertToDto(savedOrder);
    }

    @Override
    public List<OrderDTO.OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO.OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        return convertToDto(order);
    }

    @Override
    @Transactional
    public OrderDTO.OrderResponse updateOrderStatus(Long orderId, OrderDTO.UpdateStatusRequest request) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));

        try {
            Order.OrderStatus newStatus = Order.OrderStatus.valueOf(request.getStatus().toUpperCase());
            order.setOrderStatus(newStatus);
            Order updatedOrder = orderRepository.save(order);
            return convertToDto(updatedOrder);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status provided: " + request.getStatus());
        }
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new EntityNotFoundException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }

    private OrderDTO.OrderResponse convertToDto(Order order) {
        OrderDTO.OrderResponse dto = modelMapper.map(order, OrderDTO.OrderResponse.class);
        dto.setOrderStatus(order.getOrderStatus().name());

        if (order.getAccount() != null) {
            dto.setCustomerName(order.getAccount().getAccountName());
        }

        if (order.getOrderDetails() != null) {
            dto.setOrderDetails(order.getOrderDetails().stream()
                    .map(detail -> {
                        OrderDetailDTO.OrderDetailResponse detailDto = new OrderDetailDTO.OrderDetailResponse();
                        detailDto.setOrchidId(detail.getOrchid().getOrchidId());
                        detailDto.setOrchidName(detail.getOrchid().getOrchidName());
                        detailDto.setOrchidImageUrl(detail.getOrchid().getOrchidUrl());
                        detailDto.setQuantity(detail.getQuantity());
                        detailDto.setPrice(detail.getPrice());
                        return detailDto;
                    })
                    .collect(Collectors.toList()));
        }
        return dto;
    }
    @Override
    public List<OrderDTO.OrderResponse> getOrdersByCurrentUser() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Account currentUser = accountRepository.findByEmail(userEmail)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Cần thêm phương thức này vào OrderRepository
        List<Order> orders = orderRepository.findByAccount_AccountIdOrderByOrderDateDesc(currentUser.getAccountId());

        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}