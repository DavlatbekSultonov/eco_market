package com.example.foodtrove0.wishlist;

import com.example.foodtrove0.common.service.GenericService;
import com.example.foodtrove0.product.ProductRepository;
import com.example.foodtrove0.product.entity.Product;
import com.example.foodtrove0.user.UserRepository;
import com.example.foodtrove0.user.entity.User;
import com.example.foodtrove0.wishlist.dto.WishlistCreateDto;
import com.example.foodtrove0.wishlist.dto.WishlistResponseDto;
import com.example.foodtrove0.wishlist.dto.WishlistUpdateDto;
import com.example.foodtrove0.wishlist.entity.Wishlist;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class WishlistService extends GenericService<Wishlist, UUID, WishlistCreateDto, WishlistResponseDto, WishlistUpdateDto> {
    private final WishlistRepository repository;
    private final Class<Wishlist> entityClass = Wishlist.class;
    private final WishlistDtoMapper mapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Override
    protected WishlistResponseDto internalCreate(WishlistCreateDto wishlistCreateDto) {
        Wishlist wishlist = mapper.toEntity(wishlistCreateDto);
        UUID userId = wishlistCreateDto.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        wishlist.setId(UUID.randomUUID());
        wishlist.setUser(user);

        userRepository.save(user);

        Wishlist saved = repository.save(wishlist);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected WishlistResponseDto internalUpdate(UUID uuid, WishlistUpdateDto wishlistUpdateDto) {
        Wishlist wishlist = repository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException("Wishlist not found"));
        mapper.toEntity(wishlistUpdateDto, wishlist);
        Wishlist saved = repository.save(wishlist);

        return mapper.toResponseDto(saved);
    }

    @Transactional
    public WishlistResponseDto addProduct(UUID wishlistId, UUID productId) {
        Wishlist wishlist = repository.findById(wishlistId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        wishlist.getProducts().add(product);

        Wishlist saved = repository.save(wishlist);
        return mapper.toResponseDto(saved);
    }

    public WishlistResponseDto removeProduct(UUID wishlistId, UUID productId) {
        Wishlist wishlist = repository.findById(wishlistId).orElseThrow(() -> new EntityNotFoundException("Wishlist not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        wishlist.getProducts().remove(product);

        Wishlist saved = repository.save(wishlist);
        return mapper.toResponseDto(saved);
    }
}
