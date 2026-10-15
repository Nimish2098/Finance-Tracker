package com.project.financeApp.category.dto;

import java.math.BigDecimal;

public record CategoryBreakdownDTO(
        String category,
        BigDecimal amount
) {}

