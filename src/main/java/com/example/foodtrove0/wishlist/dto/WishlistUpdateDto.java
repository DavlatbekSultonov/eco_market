package com.example.foodtrove0.wishlist.dto;

import com.example.foodtrove0.product.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistUpdateDto {
    private Set<ProductResponseDto> products;
}
