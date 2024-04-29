package com.example.foodtrove0.comment;

import com.example.foodtrove0.comment.dto.CommentCreateDTO;
import com.example.foodtrove0.comment.dto.CommentResponseDto;
import com.example.foodtrove0.comment.dto.CommentUpdateDTO;
import com.example.foodtrove0.comment.entity.Comment;
import com.example.foodtrove0.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDtoMapper extends GenericMapper<Comment, CommentCreateDTO, CommentResponseDto, CommentUpdateDTO> {
    private final ModelMapper mapper;
    @Override
    public Comment toEntity(CommentCreateDTO commitCreateDTO) {
        return mapper.map(commitCreateDTO, Comment.class);
    }

    @Override
    public CommentResponseDto toResponseDto(Comment commit) {
        return mapper.map(commit, CommentResponseDto.class);
    }

    @Override
    public void toEntity(CommentUpdateDTO commitUpdateDTO, Comment commit) {
      mapper.map(commitUpdateDTO,commit);
    }
}
