package com.project.financeApp.category.dto;

import com.project.financeApp.transaction.entity.TransactionType;


public record CategoryRequestDTO(
        String name,
        TransactionType type   // ✅ NOT AccountType
) {}