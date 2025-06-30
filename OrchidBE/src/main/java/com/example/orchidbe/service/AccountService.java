package com.example.orchidbe.service;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.DTO.RegisterDTO;
import com.example.orchidbe.model.Account;

import java.util.List;

public interface AccountService {
    AccountDTO.AccountResponse getAccount(Long id);
    List<AccountDTO.AccountResponse> getAllAccounts();
    AccountDTO.AccountResponse createAccount(AccountDTO.AccountRequest accountRequest);
    AccountDTO.AccountResponse updateAccount(Long id, AccountDTO.AccountUpdateRequest accountRequest);
    void deleteAccount(Long id);
    Account validateLogin(String username, String password) ;
    AccountDTO.AccountResponse signup (RegisterDTO registerDTO) ;
}
