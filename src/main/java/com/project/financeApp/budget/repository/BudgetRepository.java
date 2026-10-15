package com.project.financeApp.budget.repository;


import com.project.financeApp.budget.entity.Budget;
import com.project.financeApp.user.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {

    @Query("SELECT b FROM Budget b WHERE b.user = :user AND b.category.id = :categoryId AND b.month = :month AND b.year = :year")
    Optional<Budget> findByUserAndCategoryIdAndMonthAndYear(
            @Param("user") User user,
            @Param("categoryId") UUID categoryId,
            @Param("month") int month,
            @Param("year") int year
    );

        @Lock(LockModeType.PESSIMISTIC_WRITE)
        @Query("SELECT b FROM Budget b WHERE b.user = :user AND b.category.id = :categoryId AND b.month = :month AND b.year = :year")
        Optional<Budget> findForUpdate(
            @Param("user") User user,
            @Param("categoryId") UUID categoryId,
            @Param("month") int month,
            @Param("year") int year
        );

        @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t "
            + "WHERE t.user = :user AND t.category.id = :categoryId "
            + "AND t.type = com.project.financeApp.transaction.entity.TransactionType.EXPENSE "
            + "AND t.transactionDate BETWEEN :startDate AND :endDate")
        java.math.BigDecimal sumExpensesForCategoryAndPeriod(
            @Param("user") User user,
            @Param("categoryId") UUID categoryId,
            @Param("startDate") java.time.LocalDate startDate,
            @Param("endDate") java.time.LocalDate endDate
        );

    List<Budget> findByUser(User user);

    Optional<Budget> findByIdAndUser(UUID id, User user);

    List<Budget> findByUserAndMonthAndYear(User user, int month, int year);
}
