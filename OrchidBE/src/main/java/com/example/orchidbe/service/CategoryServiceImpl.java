package com.example.orchidbe.service;

import com.example.orchidbe.DTO.CategoryDTO;
import com.example.orchidbe.model.Category;
import com.example.orchidbe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements  CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public Category createCategory(CategoryDTO.CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO.CategoryRequest categoryRequest) {
            Category existCategory = getCategoryById(id);
            if(categoryRepository.existsByCategoryName(categoryRequest.getName()))
                throw new IllegalArgumentException("Category already exists");
            existCategory.setCategoryName(categoryRequest.getName());
            return categoryRepository.save(existCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category existCategory = getCategoryById(id);
        categoryRepository.delete(existCategory);
    }
}
