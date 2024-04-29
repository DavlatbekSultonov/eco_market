package com.example.foodtrove0.order.entity;

import com.example.foodtrove0.address.entity.Address;
import com.example.foodtrove0.productSet.entity.ProductSet;
import com.example.foodtrove0.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(
            name = "product_set_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_set_id")
    )
    private List<ProductSet> products;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Address address;

}
