package com.example.foodtrove0.user.permission;

import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.user.permission.entity.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends GenericRepository<Permission, String> {
}
