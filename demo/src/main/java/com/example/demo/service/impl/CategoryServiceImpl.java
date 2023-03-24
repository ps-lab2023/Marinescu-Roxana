package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category updateCategory(Category category) {
        Category updateCategory = categoryRepo.findById(category.getId()).get();
        updateCategory.setName(category.getName());
        categoryRepo.save(updateCategory);
        return category;
    }

    @Override
    public Category deleteCategory(Category category) {
        Category deleteCategory = categoryRepo.findById(category.getId()).get();
        categoryRepo.delete(deleteCategory);
        return category;
    }

    @Override
    public Category createCategory(Category category) {
        categoryRepo.save(category);
        return category;
    }
}
