package com.project.financeApp.category.dto;

import com.project.financeApp.transaction.entity.TransactionType;

import java.util.UUID;

public record CategoryResponseDTO(
        UUID id,
        String name,
        TransactionType type
) {}

