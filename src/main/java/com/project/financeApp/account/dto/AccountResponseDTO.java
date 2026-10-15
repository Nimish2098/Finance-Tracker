package com.project.financeApp.account.dto;

import com.project.financeApp.account.entity.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountResponseDTO(
        UUID id,
        String name,
        AccountType type,
        BigDecimal balance
) {}
