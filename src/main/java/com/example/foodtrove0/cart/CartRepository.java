package com.example.foodtrove0.cart;

import com.example.foodtrove0.cart.entity.Cart;
import com.example.foodtrove0.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends GenericRepository<Cart, UUID> {
}
