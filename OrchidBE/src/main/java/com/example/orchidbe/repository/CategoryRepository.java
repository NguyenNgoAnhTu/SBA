package com.example.orchidbe.repository;

import com.example.orchidbe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    boolean existsByCategoryName(String name);
}
