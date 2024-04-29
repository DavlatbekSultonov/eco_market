package com.example.foodtrove0.cart.dto;

import com.example.foodtrove0.productSet.dto.ProductSetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartUpdateDto{
    private Set<ProductSetResponseDto> products;
}
