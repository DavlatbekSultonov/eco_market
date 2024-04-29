package com.example.foodtrove0.email.dto;

import com.example.foodtrove0.user.dto.UserCreateDto;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("Email")
public class EmailDto implements Serializable {

    @Email
    private String email;

    @NonNull
    private String message;

    private UserCreateDto userCreateDto;

}
