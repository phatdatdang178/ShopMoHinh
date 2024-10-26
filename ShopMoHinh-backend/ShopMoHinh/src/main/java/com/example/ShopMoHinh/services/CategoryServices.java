package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.Repositories.CategoryRepository;
import com.example.ShopMoHinh.dtos.CategoryDTO;
import com.example.ShopMoHinh.models.Category;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServices implements iCategoryServices {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category
                .builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category getCategory(long Id) {
        return categoryRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(long Id, CategoryDTO categoryDTO) {
       Category existingCategory = getCategory(Id);
       existingCategory.setName(categoryDTO.getName());
       categoryRepository.save(existingCategory);
       return existingCategory;
    }

    @Override
    public void deleteCategory(long Id) {
        //xoa cung
       categoryRepository.deleteById(Id);
    }
}
