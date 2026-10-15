package com.project.financeApp.transaction.dto;

import com.project.financeApp.transaction.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TransactionRequestDTO(
        BigDecimal amount,
        TransactionType type,
        UUID accountId,
        UUID categoryId,
        String description,
        LocalDate transactionDate
) {}

