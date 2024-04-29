package com.example.foodtrove0.cart.dto;

import com.example.foodtrove0.productSet.dto.ProductSetResponseDto;
import com.example.foodtrove0.user.dto.UserResponseDtoForCartAndOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartResponseDto{
    private UUID id;
    private UserResponseDtoForCartAndOrder user;
    private Set<ProductSetResponseDto> products;
}
