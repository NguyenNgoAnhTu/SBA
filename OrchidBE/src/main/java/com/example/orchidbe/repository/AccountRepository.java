package com.example.orchidbe.repository;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    Account  findByAccountName(String username);
}
