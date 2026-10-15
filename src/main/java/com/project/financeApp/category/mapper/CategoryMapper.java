package com.project.financeApp.category.mapper;


import com.project.financeApp.category.dto.CategoryRequestDTO;
import com.project.financeApp.category.dto.CategoryResponseDTO;
import com.project.financeApp.category.entity.Category;
import com.project.financeApp.user.entity.User;


public class CategoryMapper {

    private CategoryMapper() {
    }

    public static Category toEntity(CategoryRequestDTO dto, User user) {
        return Category.builder()
                .name(dto.name())
                .type(dto.type()) // ✅ TransactionType
                .user(user)
                .build();
    }

    public static CategoryResponseDTO toResponse(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getType()
        );
    }

}