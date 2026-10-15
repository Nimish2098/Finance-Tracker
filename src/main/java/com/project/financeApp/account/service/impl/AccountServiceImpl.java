package com.project.financeApp.account.service.impl;

import com.project.financeApp.account.service.AccountService;
import com.project.financeApp.user.service.UserService;
import com.project.financeApp.account.mapper.AccountMapper;
import com.project.financeApp.account.dto.AccountRequestDTO;
import com.project.financeApp.account.dto.AccountResponseDTO;
import com.project.financeApp.account.entity.Account;
import com.project.financeApp.user.entity.User;
import com.project.financeApp.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService; // gives logged-in user

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO request) {
        User user = userService.getCurrentUser();

        Account account = AccountMapper.toEntity(request, user);
        return AccountMapper.toResponse(accountRepository.save(account));
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        User user = userService.getCurrentUser();

        return accountRepository.findByUser(user)
                .stream()
                .map(AccountMapper::toResponse)
                .toList();
    }

    @Override
    public AccountResponseDTO getAccountById(UUID accountId) {
        User user = userService.getCurrentUser();

        Account account = accountRepository.findByIdAndUser(accountId, user)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return AccountMapper.toResponse(account);
    }



}
