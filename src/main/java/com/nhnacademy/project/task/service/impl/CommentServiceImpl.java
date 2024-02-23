package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.domain.CommentRegisterDto;
import com.nhnacademy.project.task.repository.CommentRepository;
import com.nhnacademy.project.task.service.CommentService;
import com.nhnacademy.project.task.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    @Override
    public List<CommentDto> getAllComments() {
        return repository.getAllBy();
    }

    @Override
    public CommentDto getComment(Integer commentId) {
        return repository.getByCommentId(commentId);
    }

    @Override
    public void createComment(CommentRegisterDto commentRegisterDto) {

        Comment comment = new Comment();
        BeanUtils.copyProperties(commentRegisterDto, comment);
        comment.setCreateAt(LocalDateTime.now());

        repository.save(comment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        repository.deleteById(commentId);
    }

    @Override
    public void updateComment(CommentRegisterDto commentRegisterDto, Integer commentId) {

        Comment existingComment = repository.findById(commentId).orElse(null);
        existingComment.setCreateAt(LocalDateTime.now());

        BeanUtils.copyProperties(commentRegisterDto, existingComment);
        repository.save(existingComment);

    }
}