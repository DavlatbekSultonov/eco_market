package com.example.foodtrove0.cart.dto;

import com.example.foodtrove0.productSet.dto.ProductSetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDtoForUser {
    private UUID id;
    private Set<ProductSetResponseDto> products;
}
