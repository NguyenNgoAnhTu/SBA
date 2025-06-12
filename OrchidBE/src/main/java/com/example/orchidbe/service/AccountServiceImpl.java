package com.example.orchidbe.service;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.DTO.RegisterDTO;
import com.example.orchidbe.model.Account;
import com.example.orchidbe.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl  implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private  PasswordEncoder passwordEncoder;


    @Override
    public AccountDTO.AccountResponse getAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found by id" + id));
        return modelMapper.map(account, AccountDTO.AccountResponse.class);
    }

    @Override
    public List<AccountDTO.AccountResponse> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(x -> modelMapper.map(x, AccountDTO.AccountResponse.class)).collect(Collectors.toList());
    }

    @Override
    public AccountDTO.AccountResponse createAccount(AccountDTO.AccountRequest accountRequest) {
        return null;
    }

    @Override
    public AccountDTO.AccountResponse updateAccount(Long id, AccountDTO.AccountRequest accountRequest) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }
    @Override
    public Account validateLogin(String username, String password) {
        Account account = accountRepository.findByAccountName(username);
        if (account != null && password.equals(account.getPassword())) {
            return account;
        }
        return null;
    }
    public Account signup(RegisterDTO register) {
        Account account =  Account.builder()
                .accountName(register.getFullName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .build();

        return accountRepository.save(account);
    }
}
