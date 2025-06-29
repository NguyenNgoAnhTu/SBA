package com.example.orchidbe.repository;

import com.example.orchidbe.model.Category;
import com.example.orchidbe.model.Orchid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrchidRepository extends MongoRepository<Orchid, String> {
    boolean existsByOrchidName(String name);
}
