package com.example.foodtrove0.order;

import com.example.foodtrove0.common.mapper.GenericMapper;
import com.example.foodtrove0.order.dto.OrderCreateDto;
import com.example.foodtrove0.order.dto.OrderResponseDto;
import com.example.foodtrove0.order.dto.OrderUpdateDto;
import com.example.foodtrove0.order.entity.Order;
import com.example.foodtrove0.productSet.ProductSetDtoMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class OrderDtoMapper extends GenericMapper<Order, OrderCreateDto, OrderResponseDto, OrderUpdateDto> {
    private final ModelMapper mapper;
    private final ProductSetDtoMapper productSetDtoMapper;

    @Override
    public Order toEntity(OrderCreateDto orderCreateDto) {
        return mapper.map(orderCreateDto, Order.class);
    }

    @Override
    public OrderResponseDto toResponseDto(Order order) {
        return mapper.map(order, OrderResponseDto.class);

    }

    @Override
    public void toEntity(OrderUpdateDto orderUpdateDto, Order order) {
        mapper.map(orderUpdateDto, order);
    }
}
