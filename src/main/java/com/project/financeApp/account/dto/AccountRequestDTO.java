package com.project.financeApp.account.dto;

import com.project.financeApp.account.entity.AccountType;

import java.math.BigDecimal;

public record AccountRequestDTO(
        String name,
        AccountType type,
        BigDecimal balance
) {}