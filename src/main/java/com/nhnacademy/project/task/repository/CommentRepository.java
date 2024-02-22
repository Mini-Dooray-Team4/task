package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<CommentDto> getAllBy();
    CommentDto getByCommentId(Integer commentId);
}
