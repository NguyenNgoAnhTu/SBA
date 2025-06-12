package com.example.orchidbe.controller;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.model.Account;
import com.example.orchidbe.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/accounts")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountController {
   AccountService accountService;
   @GetMapping("/me")
   public ResponseEntity<Account> authenticatedAccount() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       Account account = (Account) authentication.getPrincipal();
       return ResponseEntity.ok(account);
   }
    @GetMapping
    public ResponseEntity<List<AccountDTO.AccountResponse>> getAllAccounts() {
         return ResponseEntity.ok(accountService.getAllAccounts());
   }
}
