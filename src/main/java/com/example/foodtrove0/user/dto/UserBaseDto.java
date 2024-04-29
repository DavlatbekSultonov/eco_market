package com.example.foodtrove0.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
}
