package com.example.foodtrove0.user;

import com.example.foodtrove0.cart.CartController;
import com.example.foodtrove0.security.JwtService;
import com.example.foodtrove0.user.dto.UserCreateDto;
import com.example.foodtrove0.user.dto.UserResponseDto;
import com.example.foodtrove0.user.dto.UserSignInDto;
import com.example.foodtrove0.user.dto.UserUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(UserController.BATH_USER)
@RequiredArgsConstructor
public class UserController {
    private final CartController cartController;
    public static final String BATH_USER = "/user";

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto createDto) throws IOException {
        UserResponseDto responseDto = userService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<UserResponseDto>> getAll(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<UserResponseDto> all = userService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponseDto> get(@PathVariable UUID id) {
        UserResponseDto responseDto = userService.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable UUID id,
                                                  @RequestBody UserUpdateDto updateDto) {
        UserResponseDto responseDto = userService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> signUp(
            @RequestBody @Valid UserCreateDto userCreateDto
    ) throws IOException {
        UserResponseDto userResponseDto = userService.create(userCreateDto);



        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(userResponseDto);
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> singIn(
            @RequestBody @Valid UserSignInDto signInDto
    ) {
        UserResponseDto userResponseDto = userService.signIn(signInDto);
        String token = jwtService.generateToken(userResponseDto.getEmail());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(userResponseDto);
    }

}

