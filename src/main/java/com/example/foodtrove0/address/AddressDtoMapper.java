package com.example.foodtrove0.address;

import com.example.foodtrove0.address.dto.AddressCreateDto;
import com.example.foodtrove0.address.dto.AddressResponseDto;
import com.example.foodtrove0.address.entity.Address;
import com.example.foodtrove0.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressDtoMapper extends GenericMapper<Address, AddressCreateDto, AddressResponseDto, AddressCreateDto> {
    private final ModelMapper mapper;

    @Override
    public Address toEntity(AddressCreateDto addressDto) {
        return mapper.map(addressDto, Address.class);
    }

    @Override
    public AddressResponseDto toResponseDto(Address address) {
        return mapper.map(address, AddressResponseDto.class);
    }

    @Override
    public void toEntity(AddressCreateDto addressCreateDto, Address address) {
        mapper.map(addressCreateDto, address);
    }
}
