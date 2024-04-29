package com.example.foodtrove0.address.entity;

import com.example.foodtrove0.order.entity.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    private UUID id;
    private String city;
    private String country;
    private int postCode;
    private String region;
    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Order order;
}
