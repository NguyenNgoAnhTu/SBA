package com.example.orchidbe.service;

import com.example.orchidbe.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO.CategoryResponse createCategory(CategoryDTO.CategoryRequest categoryRequest);
    CategoryDTO.CategoryResponse getCategoryById(Long id);
    List<CategoryDTO.CategoryResponse> getAllCategories();
    CategoryDTO.CategoryResponse updateCategory(Long id, CategoryDTO.CategoryRequest categoryRequest);
    void deleteCategory(Long id);
}
