package com.example.foodtrove0.order;

import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.order.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends GenericRepository<Order, UUID> {
}
