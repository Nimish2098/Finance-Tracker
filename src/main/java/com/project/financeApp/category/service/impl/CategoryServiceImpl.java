package com.project.financeApp.category.service.impl;

import com.project.financeApp.category.service.CategoryService;
import com.project.financeApp.user.service.UserService;
import com.project.financeApp.category.mapper.CategoryMapper;
import com.project.financeApp.category.dto.CategoryRequestDTO;
import com.project.financeApp.category.dto.CategoryResponseDTO;
import com.project.financeApp.category.entity.Category;
import com.project.financeApp.user.entity.User;
import com.project.financeApp.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserService userService;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        User user = userService.getCurrentUser();

        Category category = CategoryMapper.toEntity(request, user);
        return CategoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        User user = userService.getCurrentUser();

        return categoryRepository.findByUser(user)
                .stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponseDTO updateCategory(UUID categoryID, CategoryRequestDTO request) {
        return null;
    }

    @Override
    public void deleteCategory(UUID categoryId) {
        User user = userService.getCurrentUser();

        Category category = categoryRepository
                .findByIdAndUser(categoryId, user)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryRepository.delete(category);
    }




}

