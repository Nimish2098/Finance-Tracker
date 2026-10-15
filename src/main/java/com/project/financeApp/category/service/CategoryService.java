package com.project.financeApp.category.service;

import com.project.financeApp.category.dto.CategoryRequestDTO;
import com.project.financeApp.category.dto.CategoryResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO request);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO updateCategory(UUID categoryID, CategoryRequestDTO request);

    void deleteCategory(UUID categoryId);
}
