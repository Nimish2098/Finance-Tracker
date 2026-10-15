package com.project.financeApp.budget.service;

import com.project.financeApp.budget.dto.BudgetRequestDTO;
import com.project.financeApp.budget.dto.BudgetResponseDTO;
import com.project.financeApp.budget.dto.BudgetStatusDTO;

import java.util.List;
import java.util.UUID;

public interface BudgetService {

    BudgetResponseDTO createBudget(BudgetRequestDTO request);

    List<BudgetResponseDTO> getAllBudgets();

    BudgetResponseDTO getBudgetById(UUID budgetId);

    BudgetResponseDTO updateBudget(UUID budgetId, BudgetRequestDTO request);

    void deleteBudget(UUID budgetId);

    List<BudgetResponseDTO> getBudgetsByMonthAndYear(int month, int year);

    BudgetStatusDTO getBudgetStatus(UUID budgetId);
}

