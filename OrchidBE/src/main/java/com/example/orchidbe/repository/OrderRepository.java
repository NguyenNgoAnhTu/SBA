package com.example.orchidbe.repository;

import com.example.orchidbe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByAccount_AccountIdOrderByOrderDateDesc(Long accountId);

}
