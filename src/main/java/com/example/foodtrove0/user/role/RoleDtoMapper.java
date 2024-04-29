package com.example.foodtrove0.user.role;

import com.example.foodtrove0.common.mapper.GenericMapper;
import com.example.foodtrove0.user.permission.entity.Permission;
import com.example.foodtrove0.user.role.dto.RoleCreateDto;
import com.example.foodtrove0.user.role.dto.RoleResponseDto;
import com.example.foodtrove0.user.role.dto.RoleUpdateDto;
import com.example.foodtrove0.user.role.entity.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleDtoMapper extends GenericMapper<Role, RoleCreateDto, RoleResponseDto, RoleUpdateDto> {
    private final ModelMapper modelMapper;
    @Override
    public Role toEntity(RoleCreateDto roleCreatedDto) {
       return modelMapper.map(roleCreatedDto, Role.class);

    }

    @Override
    public RoleResponseDto toResponseDto(Role role) {
        RoleResponseDto responseDto = modelMapper.map(role, RoleResponseDto.class);

        Set<String> permissions = role
                .getPermissions()
                .stream()
                .map(Permission::getName)
                .collect(Collectors.toSet());

        responseDto.setPermissions(permissions);
        return responseDto;
    }

    @Override
    public void toEntity(RoleUpdateDto roleUpdate, Role role) {
        modelMapper.map(roleUpdate,role);
    }
}
