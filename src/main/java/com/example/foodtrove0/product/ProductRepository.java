package com.example.foodtrove0.product;
import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.product.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends GenericRepository<Product, UUID> {
    Optional<Product> findByTitle(String title);
}