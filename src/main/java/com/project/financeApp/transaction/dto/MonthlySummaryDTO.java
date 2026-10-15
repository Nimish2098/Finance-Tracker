package com.project.financeApp.transaction.dto;

import java.math.BigDecimal;

public record MonthlySummaryDTO(
        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal netSavings
) {}