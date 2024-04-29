package com.example.foodtrove0.wishlist;
import com.example.foodtrove0.common.mapper.GenericMapper;
import com.example.foodtrove0.wishlist.dto.WishlistCreateDto;
import com.example.foodtrove0.wishlist.dto.WishlistResponseDto;
import com.example.foodtrove0.wishlist.dto.WishlistUpdateDto;
import com.example.foodtrove0.wishlist.entity.Wishlist;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WishlistDtoMapper extends GenericMapper<Wishlist, WishlistCreateDto, WishlistResponseDto, WishlistUpdateDto> {
    private final ModelMapper mapper;
    @Override
    public Wishlist toEntity(WishlistCreateDto wishlistCreateDto) {
        return mapper.map(wishlistCreateDto,Wishlist.class);
    }

    @Override
    public WishlistResponseDto toResponseDto(Wishlist wishlist) {
        return mapper.map(wishlist, WishlistResponseDto.class);
    }

    @Override
    public void toEntity(WishlistUpdateDto wishlistUpdateDto, Wishlist wishlist) {
        mapper.map(wishlistUpdateDto,wishlist);
    }
}
