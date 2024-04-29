package com.example.foodtrove0.comment;

import com.example.foodtrove0.comment.dto.CommentCreateDTO;
import com.example.foodtrove0.comment.dto.CommentResponseDto;
import com.example.foodtrove0.comment.dto.CommentUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(CommentController.BATH_URL)
public class CommentController {

    public static final String BATH_URL = "/commit";

    private final CommentService commitService;
    @PreAuthorize("hasAnyAuthority('commit:create')")
    @PostMapping("/create")
    public ResponseEntity<CommentResponseDto> create(@RequestBody CommentCreateDTO commitCreateDTO) throws IOException {
        CommentResponseDto commitResponseDto = commitService.create(commitCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(commitResponseDto);
    }

    @PreAuthorize("hasAnyAuthority('commit:read')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<CommentResponseDto> getId(@PathVariable UUID id){
        CommentResponseDto commitResponseDto = commitService.get(id);
        return ResponseEntity.ok(commitResponseDto);
    }

    @PreAuthorize("hasAnyAuthority('commit:read')")
    @GetMapping("/getAll")
    public ResponseEntity<Page<CommentResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate){
        Page<CommentResponseDto> all = commitService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @PreAuthorize("hasAnyAuthority('commit:update')")
    @PutMapping("/updateById/{id}")
    public ResponseEntity<CommentResponseDto> update(@PathVariable UUID id, @RequestBody CommentUpdateDTO updateDTO){
        CommentResponseDto update = commitService.update(id, updateDTO);
        return ResponseEntity.ok(update);
    }

    @PreAuthorize("hasAnyAuthority('commit:delete')")
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        commitService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
