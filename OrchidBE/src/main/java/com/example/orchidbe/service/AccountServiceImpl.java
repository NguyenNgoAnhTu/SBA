package com.example.orchidbe.service;

import com.example.orchidbe.DTO.AccountDTO;
import com.example.orchidbe.DTO.RegisterDTO;
import com.example.orchidbe.model.Account;
import com.example.orchidbe.model.Role;
import com.example.orchidbe.repository.AccountRepository;
import com.example.orchidbe.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

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
    public AccountDTO.AccountResponse updateAccount(Long id, AccountDTO.AccountUpdateRequest accountRequest) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + id));

        // Cập nhật các thông tin cơ bản
        existingAccount.setAccountName(accountRequest.getAccountName());
        existingAccount.setEmail(accountRequest.getEmail());


        // Cập nhật vai trò
        if (accountRequest.getRole() != null && !accountRequest.getRole().isEmpty()) {
            Role role = roleRepository.findByRoleName(accountRequest.getRole().toUpperCase())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found: " + accountRequest.getRole()));
            existingAccount.setRole(role);
        }

        Account updatedAccount = accountRepository.save(existingAccount);
        return convertToDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) {

    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    @Override
    public Account validateLogin(String username, String password)  {
        Account account = accountRepository.findByEmail(username)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with email: " + username));
        if (account != null && password.equals(account.getPassword())) {
            return account;
        }
        return null;
        }
    @Override
        public AccountDTO.AccountResponse signup(RegisterDTO register)  {
        Role userRole = roleRepository.findByRoleName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Account account =  Account.builder()
                    .accountName(register.getFullName())
                    .email(register.getEmail())
                    .password(register.getPassword())
                    .role(userRole)
                    .build();

             accountRepository.save(account);
             modelMapper.map(account, AccountDTO.AccountResponse.class);
             return modelMapper.map(account, AccountDTO.AccountResponse.class);
        }
    private AccountDTO.AccountResponse convertToDto(Account account) {
        AccountDTO.AccountResponse dto = modelMapper.map(account, AccountDTO.AccountResponse.class);
        if (account.getRole() != null) {
            dto.setRole(account.getRole().getRoleName());
        }
        // Sửa lại để khớp với DTO: DTO có username, nhưng entity có accountName
        dto.setAccountName(account.getAccountName());
        dto.setAccountId(account.getAccountId()); // <<--- THÊM DÒNG NÀY
        return dto;
    }

}
