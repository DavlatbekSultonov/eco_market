package com.example.foodtrove0.order.dto;

import com.example.foodtrove0.address.dto.AddressResponseDto;
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
public class OrderResponseDto{
    private UUID id;
    private AddressResponseDto address;
    private UserResponseDtoForCartAndOrder user;
    private Set<ProductSetResponseDto> products;
}
