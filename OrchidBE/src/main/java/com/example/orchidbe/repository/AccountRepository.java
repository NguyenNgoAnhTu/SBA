package com.example.orchidbe.repository;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends MongoRepository<Account, String> {
    Optional<Account> findByEmail(String email);
    Account  findByAccountName(String username);
}
