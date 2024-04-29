package com.example.foodtrove0.order.dto;

import com.example.foodtrove0.address.dto.AddressResponseDto;
import com.example.foodtrove0.productSet.dto.ProductSetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDtoForUser {
    private UUID id;
    private AddressResponseDto address;
    private Set<ProductSetResponseDto> products;
}
