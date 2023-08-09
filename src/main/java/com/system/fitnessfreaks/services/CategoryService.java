package com.system.fitnessfreaks.services;

import com.system.fitnessfreaks.Entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> fetchAll();
    Category fetchById(Integer id);
}
