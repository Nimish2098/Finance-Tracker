package com.project.financeApp.account.service;


import com.project.financeApp.account.dto.AccountRequestDTO;
import com.project.financeApp.account.dto.AccountResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountResponseDTO createAccount(AccountRequestDTO request);

    List<AccountResponseDTO> getAllAccounts();

    AccountResponseDTO getAccountById(UUID accountId);
}
