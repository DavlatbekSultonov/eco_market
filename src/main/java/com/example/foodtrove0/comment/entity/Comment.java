package com.example.foodtrove0.comment.entity;

import com.example.foodtrove0.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    private UUID id;
    private String commit;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
