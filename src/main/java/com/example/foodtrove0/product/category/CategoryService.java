package com.example.foodtrove0.product.category;
import com.example.foodtrove0.common.service.GenericService;
import com.example.foodtrove0.product.category.dto.CategoryCreateDto;
import com.example.foodtrove0.product.category.dto.CategoryResponseDto;
import com.example.foodtrove0.product.category.dto.CategoryUpdateDto;
import com.example.foodtrove0.product.category.entity.Category;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Getter
@RequiredArgsConstructor
public class CategoryService extends GenericService<Category, String, CategoryCreateDto, CategoryResponseDto, CategoryUpdateDto> {
    private final CategoryDtoMapper mapper;
    private final CategoryRepository repository;
    private final Class<Category>entityClass = Category.class;

    @Override
    protected CategoryResponseDto internalCreate(CategoryCreateDto categoryCreateDto) {
        Category entity = mapper.toEntity(categoryCreateDto);
        Category saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected CategoryResponseDto internalUpdate(String id, CategoryUpdateDto categoryUpdateDto) {
        Category category = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Category not found")
                );
        mapper.toEntity(categoryUpdateDto, category);
        Category saved = repository.save(category);
        return mapper.toResponseDto(saved);
    }
}
