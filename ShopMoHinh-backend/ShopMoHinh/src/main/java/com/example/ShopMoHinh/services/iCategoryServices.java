package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.dtos.CategoryDTO;
import com.example.ShopMoHinh.models.Category;

import java.util.List;

public interface iCategoryServices {
    Category createCategory(CategoryDTO category);

    Category getCategory(long Id);

    List<Category> getAllCategories();

    Category updateCategory(long Id, CategoryDTO category);

    void deleteCategory(long Id);
}
