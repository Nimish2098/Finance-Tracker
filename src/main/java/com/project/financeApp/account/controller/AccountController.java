package com.project.financeApp.account.controller;


import com.project.financeApp.account.service.AccountService;
import com.project.financeApp.account.dto.AccountRequestDTO;
import com.project.financeApp.account.dto.AccountResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountResponseDTO createAccount(
            @RequestBody AccountRequestDTO request
    ) {
        return accountService.createAccount(request);
    }

    @GetMapping
    public List<AccountResponseDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getAccountById(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }
}

