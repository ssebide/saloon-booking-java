package com.ssebide.service;

import java.util.Set;

import com.ssebide.modal.Category;
import com.ssebide.payload.dto.SaloonDTO;

public interface CategoryService {

    Category savedCategory(Category category, SaloonDTO saloonDTO);
    Set<Category> getAllCategoriesBySaloon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategory(Long id, Long saloonId) throws Exception;
}
