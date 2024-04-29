package com.example.foodtrove0.rating;

import com.example.foodtrove0.common.mapper.GenericMapper;
import com.example.foodtrove0.rating.dto.RatingCreateDto;
import com.example.foodtrove0.rating.dto.RatingResponseDto;
import com.example.foodtrove0.rating.dto.RatingUpdateDto;
import com.example.foodtrove0.rating.entity.Rating;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RatingDtoMapper extends GenericMapper<Rating, RatingCreateDto, RatingResponseDto, RatingUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Rating toEntity(RatingCreateDto ratingCreateDto) {
        return mapper.map(ratingCreateDto, Rating.class);
    }

    @Override
    public RatingResponseDto toResponseDto(Rating rating) {
        String userName = rating.getUser().getName();
        String productName = rating.getProduct().getTitle();
        RatingResponseDto responseDto = mapper.map(rating, RatingResponseDto.class);
        responseDto.setUser(userName);
        responseDto.setProduct(productName);
        return responseDto;
    }

    @Override
    public void toEntity(RatingUpdateDto ratingUpdateDto, Rating rating) {
        mapper.map(ratingUpdateDto, rating);
    }
}
