package com.ssebide.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssebide.modal.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Set<Category> findBySaloonId(Long saloonId);
}
