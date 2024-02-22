package com.nhnacademy.project.task.controller;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.entity.Comment;
import org.springframework.web.bind.annotation.*;
import com.nhnacademy.project.task.service.CommentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    @GetMapping
    public List<CommentDto> getAllComments() {
        return service.getAllComments();
    }

    @GetMapping("/{commentId}")
    public CommentDto getComment(@PathVariable Integer commentId) {
        return service.getComment(commentId);
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        service.createComment(comment);
    }

    @PutMapping("/{commentId}")
    public void updateComment(@RequestBody Comment comment) {
        service.updateComment(comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        service.deleteComment(commentId);
    }

}