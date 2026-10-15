package com.project.financeApp.transaction.dto;

import java.math.BigDecimal;

public record DailyCashFlowDTO(
    String date,  // "2024-06-01"
    BigDecimal inflow,
    BigDecimal outflow,
    BigDecimal balance  // running balance
) {}
