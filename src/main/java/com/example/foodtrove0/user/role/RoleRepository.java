package com.example.foodtrove0.user.role;

import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.user.role.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends GenericRepository<Role,String> {
    Optional<Role> findByName(String name);
}
