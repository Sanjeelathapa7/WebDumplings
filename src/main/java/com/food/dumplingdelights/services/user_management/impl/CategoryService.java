package com.food.dumplingdelights.services.user_management.impl;

import com.food.dumplingdelights.Entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
}
