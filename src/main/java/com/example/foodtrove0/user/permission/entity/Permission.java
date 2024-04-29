package com.example.foodtrove0.user.permission.entity;

import com.example.foodtrove0.user.entity.User;
import com.example.foodtrove0.user.role.entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    private String name;

    @ManyToMany(mappedBy = "permissions")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<User> users;

    @ManyToMany(mappedBy = "permissions")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;
}
