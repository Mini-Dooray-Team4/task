package com.nhnacademy.project.task.repository;

import com.nhnacademy.project.task.domain.CommentDto;
import com.nhnacademy.project.task.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<CommentDto> getAllByTask_TaskIdAndProject_ProjectId(Integer taskIdm, Integer projectId);
    Optional<CommentDto> getByCommentIdAndTask_TaskIdAndProject_ProjectId(Integer commentId, Integer taskId, Integer projectId);
}
