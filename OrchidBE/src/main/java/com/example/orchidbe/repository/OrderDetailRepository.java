package com.example.orchidbe.repository;

import com.example.orchidbe.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// 
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
