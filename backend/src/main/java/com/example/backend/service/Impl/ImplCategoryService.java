package com.example.backend.service.Impl;


import com.example.backend.dto.CategoryDTO;
import com.example.backend.entity.Category;

import java.util.List;

public interface ImplCategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Long categoryId, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}

