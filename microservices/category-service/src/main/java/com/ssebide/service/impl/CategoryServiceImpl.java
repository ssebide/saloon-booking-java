package com.ssebide.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssebide.modal.Category;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.repository.CategoryRepository;
import com.ssebide.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category savedCategory(Category category, SaloonDTO saloonDTO) {
        
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setSaloonId(category.getSaloonId());
        newCategory.setImage(category.getImage());

        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySaloon(Long id) {
        return categoryRepository.findBySaloonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        
        Category category = categoryRepository.findById(id).orElse(null);

        if(category == null){
            throw new Exception("Category not found");
        }
        return category;
    }

    @Override
    public void deleteCategory(Long id, Long saloonId) throws Exception {
        
        Category category =  getCategoryById(id);

        if(!category.getSaloonId().equals(saloonId)){
            throw new Exception("You dont have permission to delete this category");
        }
        categoryRepository.deleteById(id);
    }

}
