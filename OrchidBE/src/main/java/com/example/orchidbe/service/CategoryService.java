package com.example.orchidbe.service;

import com.example.orchidbe.DTO.CategoryDTO;
import com.example.orchidbe.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO.CategoryRequest categoryRequest);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Long id, CategoryDTO.CategoryRequest categoryRequest);
    void deleteCategory(Long id);
}
