package com.project.financeApp.transaction.dto;

import com.project.financeApp.category.dto.CategoryBreakdownDTO;

import java.math.BigDecimal;
import java.util.List;

public record DashboardSummaryDTO(
        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal netSavings,
        List<CategoryBreakdownDTO> expenseByCategory
) {}

