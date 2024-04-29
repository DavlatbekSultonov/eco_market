package com.example.foodtrove0.product.category;

import com.example.foodtrove0.common.mapper.GenericMapper;
import com.example.foodtrove0.product.category.dto.CategoryCreateDto;
import com.example.foodtrove0.product.category.dto.CategoryResponseDto;
import com.example.foodtrove0.product.category.dto.CategoryUpdateDto;
import com.example.foodtrove0.product.category.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDtoMapper extends GenericMapper<Category, CategoryCreateDto, CategoryResponseDto, CategoryUpdateDto> {

    private final ModelMapper mapper;
    @Override
    public Category toEntity(CategoryCreateDto categoryCreateDto) {
        return mapper.map(categoryCreateDto,Category.class);
    }

    @Override
    public CategoryResponseDto toResponseDto(Category category) {
        return mapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public void toEntity(CategoryUpdateDto categoryUpdateDto, Category category) {
        mapper.map(categoryUpdateDto,category);
    }
}
