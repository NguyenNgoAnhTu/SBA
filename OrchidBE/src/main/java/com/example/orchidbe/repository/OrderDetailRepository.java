package com.example.orchidbe.repository;

import com.example.orchidbe.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
// 
@Repository
public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {
}
