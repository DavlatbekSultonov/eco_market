package com.example.foodtrove0.user.dto;

import com.example.foodtrove0.cart.dto.CartResponseDtoForUser;
import com.example.foodtrove0.order.dto.OrderResponseDtoForUser;
import com.example.foodtrove0.user.role.dto.RoleResponseDto;
import com.example.foodtrove0.wishlist.dto.WishlistResponseDtoForUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto extends UserBaseDto{
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Set<RoleResponseDto> roles;
    private Set<String> permissions;
    private CartResponseDtoForUser cart;
    private WishlistResponseDtoForUser wishlist;
    private Set<OrderResponseDtoForUser> orders;
}
