package com.nhnacademy.project.task.service.impl;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.repository.CommentRepository;
import com.nhnacademy.project.task.service.CommentService;
import com.nhnacademy.project.task.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    public void createComment(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        repository.deleteById(commentId);
    }

    @Override
    public void updateComment(Comment comment) {
        if (repository.existsById(comment.getCommentId())) {
            repository.save(comment);
        }
    }
}