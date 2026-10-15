package com.project.financeApp.account.mapper;


import com.project.financeApp.account.dto.AccountRequestDTO;
import com.project.financeApp.account.dto.AccountResponseDTO;
import com.project.financeApp.account.entity.Account;
import com.project.financeApp.user.entity.User;

public class AccountMapper {

    private AccountMapper() {}

    public static Account toEntity(AccountRequestDTO dto, User user) {
        return Account.builder()
                .name(dto.name())
                .type(dto.type())
                .balance(dto.balance())
                .user(user)
                .build();
    }

    public static AccountResponseDTO toResponse(Account entity) {
        return new AccountResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getBalance()
        );
    }
}

