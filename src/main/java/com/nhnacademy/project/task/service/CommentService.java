package com.nhnacademy.project.task.service;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.domain.CommentRegisterDto;
import com.nhnacademy.project.task.entity.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComments();
    CommentDto getComment(Integer commentId);
    void createComment(CommentRegisterDto commentRegisterDto);
    void updateComment(CommentRegisterDto commentRegisterDto, Integer commentId);
    void deleteComment(Integer commentId);

}
