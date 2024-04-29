package com.example.foodtrove0.user;

import com.example.foodtrove0.common.exceptions.WrongInputException;
import com.example.foodtrove0.common.service.GenericService;
import com.example.foodtrove0.email.dto.EmailDto;
import com.example.foodtrove0.user.dto.UserCreateDto;
import com.example.foodtrove0.user.dto.UserResponseDto;
import com.example.foodtrove0.user.dto.UserSignInDto;
import com.example.foodtrove0.user.dto.UserUpdateDto;
import com.example.foodtrove0.user.entity.User;
import com.example.foodtrove0.user.otp.OtpRepository;
import com.example.foodtrove0.user.otp.entity.Otp;
import com.example.foodtrove0.user.role.RoleRepository;
import com.example.foodtrove0.validation.UserValidation;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static com.example.foodtrove0.common.ExcMessage.*;


@Service
@Getter
@RequiredArgsConstructor
public class UserService extends GenericService<User, UUID, UserCreateDto, UserResponseDto, UserUpdateDto> implements UserDetailsService {
    private final UserRepository repository;
    private final Class<User> entityClass = User.class;
    private final UserDtoMapper mapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final OtpRepository otpRepository;
    private final NotificationService notificationService;
    private final Random random = new Random();
    private final RedisTemplate<String, EmailDto> redisTemplate;
    private final UserValidation validation;

    @Override
    protected UserResponseDto internalCreate(UserCreateDto user) {

        if (!validation.isValidPassword(user.getPassword())) {
            throw new WrongInputException(INVALID_PASSWORD);
        }
        if (!validation.isValidPhoneNumber(user.getPhoneNumber())) {
            throw new WrongInputException(INVALID_PHONE_NUMBER);
        }
        if (!validation.isValidEmail(user.getEmail())) {
            throw new WrongInputException(INVALID_EMAIL);
        }

        int code = random.nextInt(1000, 10000);
        notificationService.sendVerifyCode(user.getEmail(), code);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Otp otp = new Otp(user.getEmail(), code, 1, LocalDateTime.now(), LocalDateTime.now(), user);
        otpRepository.save(otp);
        return mapper.userResponseDto(user);

    }

    @Override
    protected UserResponseDto internalUpdate(UUID uuid, UserUpdateDto userUpdateDto) {
        return null;
    }


    @Transactional
    public UserResponseDto signIn(UserSignInDto signInDto) {
        User user = repository.findByEmail(signInDto.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Username or password is not correct"));

        if (!passwordEncoder.matches(signInDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Username or password is not correct");
        }

        return mapper.toResponseDto(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new BadCredentialsException(BAD_CREDENTIALS));
    }
}
