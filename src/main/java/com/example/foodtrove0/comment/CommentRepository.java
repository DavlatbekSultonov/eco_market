package com.example.foodtrove0.comment;

import com.example.foodtrove0.comment.entity.Comment;
import com.example.foodtrove0.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends GenericRepository<Comment, UUID> {
}
