package com.example.foodtrove0.productSet;

import com.example.foodtrove0.common.mapper.GenericMapper;
import com.example.foodtrove0.productSet.dto.ProductSetCreateDto;
import com.example.foodtrove0.productSet.dto.ProductSetResponseDto;
import com.example.foodtrove0.productSet.dto.ProductSetUpdateDto;
import com.example.foodtrove0.productSet.entity.ProductSet;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSetDtoMapper extends GenericMapper<ProductSet, ProductSetCreateDto, ProductSetResponseDto, ProductSetUpdateDto> {

    private final ModelMapper mapper;

    @Override
    public ProductSet toEntity(ProductSetCreateDto productSetCreateDto) {
        return mapper.map(productSetCreateDto, ProductSet.class);
    }

    @Override
    public ProductSetResponseDto toResponseDto(ProductSet productSet) {
        return mapper.map(productSet, ProductSetResponseDto.class);
    }

    @Override
    public void toEntity(ProductSetUpdateDto productSetUpdateDto, ProductSet productSet) {
        mapper.map(productSetUpdateDto,productSet);
    }
}
