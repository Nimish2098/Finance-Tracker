package com.project.financeApp.account.repository;


import com.project.financeApp.account.entity.Account;
import com.project.financeApp.user.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    List<Account> findByUser(User user);

    Optional<Account> findByIdAndUser(UUID id, User user);
    Optional<Account> findByNameAndUser(String name, User user);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM Account a WHERE a.id = :id AND a.user = :user")
    Optional<Account> findByIdAndUserForUpdate(
            @Param("id") UUID id,
            @Param("user") User user
    );

}

