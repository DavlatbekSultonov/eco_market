package com.example.foodtrove0.productSet;

import com.example.foodtrove0.cart.CartRepository;
import com.example.foodtrove0.cart.entity.Cart;
import com.example.foodtrove0.common.service.GenericService;
import com.example.foodtrove0.product.ProductRepository;
import com.example.foodtrove0.product.entity.Product;
import com.example.foodtrove0.productSet.dto.ProductSetCreateDto;
import com.example.foodtrove0.productSet.dto.ProductSetResponseDto;
import com.example.foodtrove0.productSet.dto.ProductSetUpdateDto;
import com.example.foodtrove0.productSet.entity.ProductSet;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Getter
public class ProductSetService extends GenericService<ProductSet, UUID, ProductSetCreateDto, ProductSetResponseDto, ProductSetUpdateDto> {
    private final ProductSetRepository repository;
    private final Class<ProductSet> entityClass = ProductSet.class;
    private final ProductSetDtoMapper mapper;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Override
    protected ProductSetResponseDto internalCreate(ProductSetCreateDto createDto) {
        ProductSet productSet = mapper.toEntity(createDto);
        productSet.setId(UUID.randomUUID());

        UUID productId = createDto.getProductId();
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productSet.setProduct(product);

        UUID cartId = createDto.getCartId();
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        productSet.setCart(cart);
        cart.getProducts().add(productSet);
        cartRepository.save(cart);

        productRepository.save(product);
        ProductSet saved = repository.save(productSet);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected ProductSetResponseDto internalUpdate(UUID uuid, ProductSetUpdateDto updateDto) {
        ProductSet productSet = repository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException("ProductSet with id: %s not fount".formatted(uuid)));
        mapper.toEntity(updateDto, productSet);
        ProductSet saved = repository.save(productSet);

        return mapper.toResponseDto(saved);
    }

}
