package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.entity.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComments();
    CommentDto getComment(Integer commentId);
    void createComment(Comment comment);
    void deleteComment(Integer commentId);

    void updateComment(Comment comment);
}
