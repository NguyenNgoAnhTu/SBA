package com.example.orchidbe.repository;

import com.example.orchidbe.model.Category;
import com.example.orchidbe.model.Orchid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrchidRepository extends JpaRepository<Orchid, Long> {
    boolean existsByOrchidName(String name);
    List<Orchid> findByCategoryCategoryId(Long categoryId);

}
