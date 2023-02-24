package com.food.dumplingdelights.services.user_management.impl;


import com.food.dumplingdelights.Entity.Category;
import com.food.dumplingdelights.repo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
