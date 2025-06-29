package com.example.orchidbe.config;

import com.example.orchidbe.model.Account;
import com.example.orchidbe.model.Role;
import com.example.orchidbe.repository.AccountRepository;
import com.example.orchidbe.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitialLizer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void run(String... args) {
        // Create roles
//        if (accountRepository.findAll().size() == 0) {
//            Role adminRole = new Role();
//            adminRole.setRoleName("ROLE_ADMIN");
//            roleRepository.save(adminRole);
//
//            Role userRole = new Role();
//            userRole.setRoleName("ROLE_USER");
//            roleRepository.save(userRole);
//
//            // Create admin account
//            Account adminAccount = new Account();
//            adminAccount.setAccountName("admin");
//            adminAccount.setEmail("admin");
//            adminAccount.setPassword("@1");
//            adminAccount.setRole(adminRole);
//            accountRepository.save(adminAccount);
//
//            // Create user account
//            Account userAccount = new Account();
//            userAccount.setAccountName("user");
//            userAccount.setEmail("user");
//            userAccount.setPassword("@1");
//            userAccount.setRole(userRole);
//            accountRepository.save(userAccount);
//        }
    }
}