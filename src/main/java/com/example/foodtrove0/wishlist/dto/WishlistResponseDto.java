package com.example.foodtrove0.wishlist.dto;

import com.example.foodtrove0.product.dto.ProductResponseDto;
import com.example.foodtrove0.user.dto.UserResponseDtoForCartAndOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistResponseDto {
    private UUID id;
    private UserResponseDtoForCartAndOrder user;
    private Set<ProductResponseDto> products;
}
