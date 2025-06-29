package com.example.orchidbe.repository;

import com.example.orchidbe.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {
    Role findByRoleName(String roleName);
}
