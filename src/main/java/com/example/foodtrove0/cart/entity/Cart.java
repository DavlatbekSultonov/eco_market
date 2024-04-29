package com.example.foodtrove0.cart.entity;

import com.example.foodtrove0.productSet.entity.ProductSet;
import com.example.foodtrove0.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cart {
    @Id
    private UUID id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProductSet> products;
}
