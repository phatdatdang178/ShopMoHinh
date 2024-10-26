package com.example.ShopMoHinh.controllers;

import com.example.ShopMoHinh.dtos.CategoryDTO;
import com.example.ShopMoHinh.models.Category;
import com.example.ShopMoHinh.services.CategoryServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServices categoryServices;
    @PostMapping("")
    public ResponseEntity<?> createAllCategories(
            @Valid @RequestBody CategoryDTO categoryDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        categoryServices.createCategory(categoryDTO);
        return  ResponseEntity.ok("Insert category successfully");
    }
    //Hien thi tat ca
    @GetMapping("") //http://localhost:8088/api/v1/categories?page=1&limit=10
    public ResponseEntity<List<Category>> getAllCategories(
            @RequestParam("page")  int page,
            @RequestParam("limit")  int limit
    ) {
        List< Category> categories= categoryServices.getAllCategories();
        return  ResponseEntity.ok(categories);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAllCategories(
            @PathVariable Long id,
            @Valid @RequestBody CategoryDTO categoryDTO
    ){
        categoryServices.updateCategory(id, categoryDTO);

        return  ResponseEntity.ok("Update category successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAllCategories(@PathVariable Long id) {
        categoryServices.deleteCategory(id);
        return  ResponseEntity.ok("Delete category successfully");
    }

}
