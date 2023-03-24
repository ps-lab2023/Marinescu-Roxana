package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.stereotype.Component;

@Component
public interface CategoryService {
    public Category updateCategory(Category category);
    public Category deleteCategory(Category category);
    public Category createCategory(Category category);
}
