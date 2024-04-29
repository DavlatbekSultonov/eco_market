package com.example.foodtrove0.comment;

import com.example.foodtrove0.comment.dto.CommentCreateDTO;
import com.example.foodtrove0.comment.dto.CommentResponseDto;
import com.example.foodtrove0.comment.dto.CommentUpdateDTO;
import com.example.foodtrove0.comment.entity.Comment;
import com.example.foodtrove0.common.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Getter
public class CommentService extends GenericService<Comment, UUID, CommentCreateDTO, CommentResponseDto, CommentUpdateDTO> {
    private final CommentRepository repository;
    private final Class<Comment> entityClass= Comment.class;
    private final CommentDtoMapper mapper;


    @Override
    protected CommentResponseDto internalCreate(CommentCreateDTO commitCreateDTO) {
        Comment entity = mapper.toEntity(commitCreateDTO);
        Comment save = repository.save(entity);
        return mapper.toResponseDto(save);
    }

    @Override
    protected CommentResponseDto internalUpdate(UUID uuid, CommentUpdateDTO commitUpdateDTO) {

        Comment commit = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(commitUpdateDTO,commit);
        repository.save(commit);

        return mapper.toResponseDto(commit);
    }
}
