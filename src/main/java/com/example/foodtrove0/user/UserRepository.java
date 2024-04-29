package com.example.foodtrove0.user;

import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends GenericRepository<User, UUID> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByEmail(String email);

}

