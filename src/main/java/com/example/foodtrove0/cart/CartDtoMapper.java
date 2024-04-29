package com.example.foodtrove0.cart;

import com.example.foodtrove0.cart.dto.CartCreateDto;
import com.example.foodtrove0.cart.dto.CartResponseDto;
import com.example.foodtrove0.cart.dto.CartUpdateDto;
import com.example.foodtrove0.cart.entity.Cart;
import com.example.foodtrove0.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartDtoMapper extends GenericMapper<Cart, CartCreateDto, CartResponseDto, CartUpdateDto> {
    private final ModelMapper mapper;
    @Override
    public Cart toEntity(CartCreateDto cartCreateDto) {
        return mapper.map(cartCreateDto,Cart.class);
    }

    @Override
    public CartResponseDto toResponseDto(Cart cart) {
        return mapper.map(cart, CartResponseDto.class);
    }

    @Override
    public void toEntity(CartUpdateDto cartUpdateDto, Cart cart) {
       mapper.map(cartUpdateDto,cart);
    }
}
