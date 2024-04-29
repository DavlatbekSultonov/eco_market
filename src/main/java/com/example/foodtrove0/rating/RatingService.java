package com.example.foodtrove0.rating;

import com.example.foodtrove0.common.service.GenericService;
import com.example.foodtrove0.product.ProductRepository;
import com.example.foodtrove0.product.entity.Product;
import com.example.foodtrove0.rating.dto.RatingCreateDto;
import com.example.foodtrove0.rating.dto.RatingResponseDto;
import com.example.foodtrove0.rating.dto.RatingUpdateDto;
import com.example.foodtrove0.rating.entity.Rating;
import com.example.foodtrove0.user.UserRepository;
import com.example.foodtrove0.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class RatingService extends GenericService<Rating, UUID, RatingCreateDto, RatingResponseDto, RatingUpdateDto> {
    private final RatingRepository repository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final Class<Rating> entityClass = Rating.class;
    private final RatingDtoMapper mapper;

    @Override
    protected RatingResponseDto internalCreate(RatingCreateDto ratingCreateDto) {
        Rating rating = mapper.toEntity(ratingCreateDto);

        UUID productId = ratingCreateDto.getProductId();
        UUID userId = ratingCreateDto.getUserId();

        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        rating.setUser(user);
        rating.setProduct(product);
        rating.setId(UUID.randomUUID());
        product.getRatings().add(rating);

        productRepository.save(product);
        userRepository.save(user);
        Rating saved = repository.save(rating);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected RatingResponseDto internalUpdate(UUID uuid, RatingUpdateDto ratingUpdateDto) {
        return null;
    }
}
