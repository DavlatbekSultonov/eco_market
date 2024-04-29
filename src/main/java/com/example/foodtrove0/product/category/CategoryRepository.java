package com.example.foodtrove0.product.category;

import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.product.category.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface CategoryRepository extends GenericRepository<Category, String> {
    Set<Category> findAllByNameIn(Set<String>names);
}
