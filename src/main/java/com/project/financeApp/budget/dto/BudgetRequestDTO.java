package com.project.financeApp.budget.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record BudgetRequestDTO(
        UUID categoryId,
        BigDecimal budgetAmount,
        int month,
        int year
) {}

