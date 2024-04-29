package com.example.foodtrove0.productSet.dto;

import com.example.foodtrove0.product.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSetResponseDto {
    private UUID id;
    private int quantity;
    private ProductResponseDto product;
}
