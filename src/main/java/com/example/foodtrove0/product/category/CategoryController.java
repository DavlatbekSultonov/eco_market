package com.example.foodtrove0.product.category;

import com.example.foodtrove0.product.category.dto.CategoryCreateDto;
import com.example.foodtrove0.product.category.dto.CategoryResponseDto;
import com.example.foodtrove0.product.category.dto.CategoryUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping(CategoryController.BATH_URL)
@RequiredArgsConstructor
public class CategoryController {

    public static final String BATH_URL = "/category";

    private final CategoryService categoryService;

     @PreAuthorize("hasAnyAuthority('category:create')")
    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody @Valid CategoryCreateDto categoryCreateDto) throws IOException {
        CategoryResponseDto categoryResponseDto = categoryService.create(categoryCreateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryResponseDto);
    }
    @PreAuthorize("hasAnyAuthority('category:read')")
    @GetMapping("/getAll")
    public ResponseEntity<Page<CategoryResponseDto>> getAllCategory(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<CategoryResponseDto> categoryResponseDtoPage = categoryService.getAll(predicate, pageable);
        return ResponseEntity.ok(categoryResponseDtoPage);
    }
    @PreAuthorize("hasAnyAuthority('category:read')")
    @GetMapping("/getByName/{name}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable String name) {
        CategoryResponseDto categoryResponseDto = categoryService.get(name);
        return ResponseEntity.ok(categoryResponseDto);
    }
    @PreAuthorize("hasAnyAuthority('category:update')")
    @PutMapping("/updateByName/{name}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable String name, @RequestBody CategoryUpdateDto categoryUpdateDto) {
        CategoryResponseDto categoryResponseDto = categoryService.update(name, categoryUpdateDto);
        return ResponseEntity.ok(categoryResponseDto);
    }
    @PreAuthorize("hasAnyAuthority('category:delete')")
    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<?> deleteCategory(@PathVariable String name) {
        categoryService.delete(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
