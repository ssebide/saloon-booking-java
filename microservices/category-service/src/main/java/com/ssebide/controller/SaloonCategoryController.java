package com.ssebide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssebide.modal.Category;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.service.CategoryService;

@RestController
@RequestMapping("/api/categories/saloon-owner")
public class SaloonCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        SaloonDTO saloonDTO = new SaloonDTO();

        saloonDTO.setId(1L);
        Category savedCategory = categoryService.savedCategory(category, saloonDTO);

        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
        SaloonDTO saloonDTO = new SaloonDTO();

        saloonDTO.setId(1L);
        categoryService.deleteCategory(id, saloonDTO.getId());

        return ResponseEntity.ok("Category deleted successfully");
    }
}
