package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.domain.CommentRegisterDto;
import com.nhnacademy.project.task.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentDto> getAllComments(Integer taskId, Integer projectId);
    Optional<CommentDto> getComment(Integer commentId, Integer taskId, Integer projectId);
    void createComment(CommentRegisterDto commentRegisterDto);
    void updateComment(CommentRegisterDto commentRegisterDto, Integer commentId);
    void deleteComment(Integer commentId);

}
