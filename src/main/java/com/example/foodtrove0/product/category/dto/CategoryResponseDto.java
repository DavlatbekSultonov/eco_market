package com.example.foodtrove0.product.category.dto;

import com.example.foodtrove0.product.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {
    private String name;
    private List<ProductResponseDto> products;
}
