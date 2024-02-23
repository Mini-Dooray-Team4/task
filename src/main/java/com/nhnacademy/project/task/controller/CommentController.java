package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.domain.CommentRegisterDto;
import com.nhnacademy.project.task.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity
                .ok()
                .body(commentService.getAllComments());
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Integer commentId) {

        return ResponseEntity
                .ok()
                .body(commentService.getComment(commentId));
    }

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentRegisterDto commentRegisterDto) {
        commentService.createComment(commentRegisterDto);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@RequestBody CommentRegisterDto commentRegisterDto,
                                              @PathVariable("commentId") Integer commentId) {
        commentService.updateComment(commentRegisterDto, commentId);
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity
                .ok()
                .build();
    }

}