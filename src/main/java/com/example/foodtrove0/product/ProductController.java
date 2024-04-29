package com.example.foodtrove0.product;

import com.example.foodtrove0.product.dto.ProductCreateDto;
import com.example.foodtrove0.product.dto.ProductResponseDto;
import com.example.foodtrove0.product.dto.ProductUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(ProductController.BATH_URL)
@RequiredArgsConstructor
public class ProductController {

    public static final String BATH_URL = "/product";

    private final ProductService productService;
    @PreAuthorize("hasAnyAuthority('product:create')")
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDto> createProduct(@ModelAttribute @Valid ProductCreateDto productCreateDto) throws IOException {
        ProductResponseDto productResponseDto = productService.create(productCreateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productResponseDto);
    }
    @PreAuthorize("hasAnyAuthority('product:read')")
    @GetMapping("/getAll")
    public ResponseEntity<Page<ProductResponseDto>>getAllProduct(@RequestParam(required = false) String predicate, Pageable pageable){
        Page<ProductResponseDto> productResponseDtoPage = productService.getAll(predicate, pageable);
        return ResponseEntity.ok(productResponseDtoPage);
    }
    @PreAuthorize("hasAnyAuthority('product:read')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductResponseDto>getProduct(@PathVariable UUID id){
        ProductResponseDto productResponseDto = productService.get(id);
        return ResponseEntity.ok(productResponseDto);
    }
    @PreAuthorize("hasAnyAuthority('product:read')")
    @GetMapping("/getProductTitle/{productTitle}")
    public ResponseEntity<ProductResponseDto>getProduct(@PathVariable String productTitle){
        ProductResponseDto productResponseDto = productService.getByTitle(productTitle);
        return ResponseEntity.ok(productResponseDto);
    }
    @PreAuthorize("hasAnyAuthority('product:update')")
    @PutMapping("/updateById/{id}")
    public ResponseEntity<ProductResponseDto>updateProduct(@PathVariable UUID id, @RequestBody ProductUpdateDto productUpdateDto){
        ProductResponseDto productResponseDto = productService.internalUpdate(id, productUpdateDto);
        return ResponseEntity.ok(productResponseDto);
    }
    @PreAuthorize("hasAnyAuthority('product:delete')")
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
