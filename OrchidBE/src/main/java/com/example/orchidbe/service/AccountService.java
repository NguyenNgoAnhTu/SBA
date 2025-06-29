package com.example.orchidbe.service;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.model.Account;

import java.util.List;

public interface AccountService {
    AccountDTO.AccountResponse getAccount(String id);
    List<AccountDTO.AccountResponse> getAllAccounts();
    AccountDTO.AccountResponse createAccount(AccountDTO.AccountRequest accountRequest);
    AccountDTO.AccountResponse updateAccount(String id, AccountDTO.AccountRequest accountRequest);
    void deleteAccount(String id);
    Account validateLogin(String username, String password) ;
}
