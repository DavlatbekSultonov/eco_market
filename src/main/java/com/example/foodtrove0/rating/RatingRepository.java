package com.example.foodtrove0.rating;

import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.rating.entity.Rating;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingRepository extends GenericRepository<Rating, UUID> {
}
