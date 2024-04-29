package com.example.foodtrove0.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateEmailRequestDto {
    private String email;
    private Integer code;
}
