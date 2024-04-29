package com.example.foodtrove0.productSet.entity;

import com.example.foodtrove0.cart.entity.Cart;
import com.example.foodtrove0.order.entity.Order;
import com.example.foodtrove0.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductSet {
    @Id
    private UUID id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToMany(mappedBy = "products")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Order> orders;
}
